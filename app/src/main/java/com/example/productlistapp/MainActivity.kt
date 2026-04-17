// *******************************************************************************
// File Header
// Course code and lab number: [COURSE CODE] – [LAB NUMBER]
// Full name and Student ID: [YOUR FULL NAME] – [YOUR STUDENT ID]
// Date of Submission: [YYYY-MM-DD]
// Short description:
//   This app displays a list of products in a RecyclerView.
//   Clicking a product opens a detail screen and passes product data
//   using Intent extras.
// *******************************************************************************

package com.example.productlistapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Main screen that displays the list of products.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    /**
     * Called when the activity is created.
     *
     * @param savedInstanceState Previously saved state bundle.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val products = listOf(
            Product("Laptop", "$899.99", "High-performance laptop for work and study."),
            Product("Smartphone", "$699.99", "Modern smartphone with excellent camera."),
            Product("Headphones", "$129.99", "Wireless headphones with noise cancellation."),
            Product("Smartwatch", "$199.99", "Fitness tracking smartwatch with AMOLED display."),
            Product("Tablet", "$349.99", "Lightweight tablet for entertainment and reading."),
            Product("Keyboard", "$79.99", "Mechanical keyboard with RGB lighting.")
        )

        adapter = ProductAdapter(products) { selectedProduct ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("product_name", selectedProduct.name)
                putExtra("product_price", selectedProduct.price)
                putExtra("product_description", selectedProduct.description)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}