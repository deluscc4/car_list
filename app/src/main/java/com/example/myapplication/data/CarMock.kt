package com.example.myapplication.data

import com.example.myapplication.model.Car

class CarMock {
    var carList = ArrayList<Car>()

    init{
        carList.add(Car(0, "Ferrari"))
        carList.add(Car(1, "Lamborghini"))
        carList.add(Car(2, "McLaren"))
        carList.add(Car(3, "Mercedes"))
    }
}