package com.example.myapplication.adapter;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Car


public class CarListAdapter(val carList: ArrayList<Car>, val onClickListener: OnClickListener) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {
    var countOnCreate = 0
    var countOnBind = 0

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_model)
    }

    class OnClickListener(val clickListener: (car: Car) -> Unit) {
        fun onClick(car: Car) = clickListener(car)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_car_list, parent, false)

        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        holder.textView.setText(car.model)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(car)
        }
    }
}
