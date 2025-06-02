package com.example.myrestappfilippomattioli

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class SearchActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var searchInput: EditText
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        listView = findViewById(R.id.listViewSongs)
        searchInput = findViewById(R.id.editTextSearch)

        searchInput.setOnEditorActionListener { v, actionId, event ->
            val query = searchInput.text.toString()
            if (query.isNotEmpty()) {
                fetchSongs(query)
            }
            true
        }
    }

    private fun fetchSongs(query: String) {
        val url = "https://itunes.apple.com/search?term=${query.replace(" ", "+")}&media=music"

        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(this@SearchActivity, "Errore di rete", Toast.LENGTH_SHORT).show()
                }
                Log.e("API", "Errore: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string()
                val results = mutableListOf<String>()

                try {
                    val jsonObject = JSONObject(json!!)
                    val jsonArray = jsonObject.getJSONArray("results")

                    for (i in 0 until jsonArray.length()) {
                        val item = jsonArray.getJSONObject(i)
                        val title = item.getString("trackName")
                        val artist = item.getString("artistName")
                        results.add("$title – $artist")
                    }

                    runOnUiThread {
                        val adapter = ArrayAdapter(this@SearchActivity, android.R.layout.simple_list_item_1, results)
                        listView.adapter = adapter
                    }

                } catch (e: Exception) {
                    runOnUiThread {
                        Toast.makeText(this@SearchActivity, "Errore", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}