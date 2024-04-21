package com.example.myapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.CarListAdapter
import com.example.myapplication.data.CarMock
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Car

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CarListAdapter
    private lateinit var mock: CarMock
    private var pos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        mock = CarMock()
        adapter = CarListAdapter(mock.carList, CarListAdapter.OnClickListener { car ->
            pos = fetchCarPosition(car.id)
            binding.editModel.setText(mock.carList[pos].model)
        })

        binding.recyclerView.adapter = adapter

        binding.buttonInsert.setOnClickListener {
            val model = binding.editModel.text.toString()
            mock.carList.add(Car(adapter.itemCount, model))
            adapter.notifyDataSetChanged()
        }
        binding.buttonEdit.setOnClickListener {
            if (pos >= 0) {
                val model = binding.editModel.text.toString()
                mock.carList[pos].model = model
                mock.carList[pos].id = pos
                pos = -1

                adapter.notifyDataSetChanged()
            }
        }
        binding.buttonDelete.setOnClickListener {
            if (pos >= 0) {
                mock.carList.removeAt(pos)
                pos = -1

                adapter.notifyDataSetChanged()
            }
        }

    }

    private fun fetchCarPosition(id: Int): Int {
        for (i in 0 .. mock.carList.size) {
            if (mock.carList[i].id == id) {
                return i
            }
        }
        return -1
    }
}