// *******************************************************************************
// File Header
// Course code and lab number: MAD302 – Assignment2
// Full name and Student ID: Ramandeep Singh – A00194321
// Date of Submission: 2026/04/17
// Short description:
//   This app displays a list of products in a RecyclerView,
//   allows the user to click a product, and opens a detail screen
//   showing the selected product's information.
// *******************************************************************************

package com.example.productlistapp

/**
 * Data model representing a product.
 *
 * @property name Product name.
 * @property price Product price.
 * @property description Product description.
 */
data class Product(
    val name: String,
    val price: String,
    val description: String
)