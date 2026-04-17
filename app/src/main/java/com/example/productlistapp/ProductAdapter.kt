package com.example.productlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for displaying a list of products in a RecyclerView.
 *
 * @param products List of products to display.
 * @param onItemClick Lambda callback when a product is clicked.
 */
class ProductAdapter(
    private val products: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /**
     * ViewHolder that holds product row views.
     *
     * @param itemView The item layout view.
     */
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textName)
        val textPrice: TextView = itemView.findViewById(R.id.textPrice)
        val textDescription: TextView = itemView.findViewById(R.id.textDescription)
    }

    /**
     * Creates a new ViewHolder.
     *
     * @param parent Parent ViewGroup.
     * @param viewType View type.
     * @return A new ProductViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    /**
     * Binds product data to a ViewHolder.
     *
     * @param holder The ViewHolder to bind.
     * @param position Item position in the list.
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.textName.text = product.name
        holder.textPrice.text = "Price: ${product.price}"
        holder.textDescription.text = product.description

        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
    }

    /**
     * Returns the total number of products.
     *
     * @return Number of items in the list.
     */
    override fun getItemCount(): Int = products.size
}