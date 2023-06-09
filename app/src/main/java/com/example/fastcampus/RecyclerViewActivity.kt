package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList = mutableListOf<Car>()
        for (i in 1..100) {
            carList.add(Car("" + i + "번째 자동차", "" + i + "번째 엔진"))

        }
        // 장착
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // 리사이클러뷰에 어답터 장착
        recyclerView.adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this))
        // 리사이클러뷰에 레이아웃매니저 장착
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
//        recyclerView.layoutManager = GridLayoutManager(this, 2)


    }
}

class RecyclerViewAdapter(
    // outer class
    var carList: MutableList<Car>,
    var inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // inner class
        // 아이템뷰의 상세 뷰 컴포넌트를 홀드한다.
        val carImage: ImageView
        val nthCar: TextView
        val nthEngine: TextView

        init {
            carImage = itemView.findViewById(R.id.carImage)
            nthCar = itemView.findViewById(R.id.nthCar)
            nthEngine = itemView.findViewById(R.id.nthEngine)
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val car = carList.get(position)
                Log.d("testt", car.nthCar)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 아이템뷰를 리턴
        val view = inflater.inflate(R.layout.car_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 데이터를 아이템뷰의 뷰컴포넌트와 묶는다(뷰를 채워준다.)
        holder.nthCar.text = carList.get(position).nthCar
        holder.nthEngine.text = carList.get(position).nthEngine
    }

    override fun getItemCount(): Int {
        return carList.size
    }


}