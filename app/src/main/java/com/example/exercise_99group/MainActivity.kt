package com.example.exercise_99group

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_99group.data.remote.RetrofitClient
import com.example.exercise_99group.domain.model.ApartmentResponse
import com.example.exercise_99group.presentation.apartmentlist.ApartmentAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var apartmentAdapter: ApartmentAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from API
        fetchApartmentData()
    }

    private fun fetchApartmentData() {
        RetrofitClient.instance.getApartments().enqueue(object : Callback<List<ApartmentResponse>> {
            override fun onResponse(
                call: Call<List<ApartmentResponse>>,
                response: Response<List<ApartmentResponse>>
            ) {
                if (response.isSuccessful) {
                    val apartmentList = response.body() ?: emptyList()
                    apartmentAdapter = ApartmentAdapter(apartmentList)
                    recyclerView.adapter = apartmentAdapter
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ApartmentResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
