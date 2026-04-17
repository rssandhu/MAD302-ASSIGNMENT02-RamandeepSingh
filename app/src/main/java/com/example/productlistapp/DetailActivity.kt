// *******************************************************************************
// File Header
// Course code and lab number: MAD302 – Assignment2
// Full name and Student ID: Ramandeep Singh – A00194321
// Date of Submission: 2026/04/17
// Short description:
//   This activity receives product data from MainActivity using Intent extras
//   and displays the selected product details.
// *******************************************************************************

package com.example.productlistapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Displays details for a selected product.
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var textName: TextView
    private lateinit var textPrice: TextView
    private lateinit var textDescription: TextView

    /**
     * Called when the activity is created.
     *
     * @param savedInstanceState Previously saved state bundle.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textName = findViewById(R.id.textDetailName)
        textPrice = findViewById(R.id.textDetailPrice)
        textDescription = findViewById(R.id.textDetailDescription)

        // Null-safe data retrieval from Intent extras
        val name = intent.getStringExtra("product_name") ?: "Unknown Product"
        val price = intent.getStringExtra("product_price") ?: "Price not available"
        val description = intent.getStringExtra("product_description") ?: "No description available"

        textName.text = name
        textPrice.text = price
        textDescription.text = description
    }
}