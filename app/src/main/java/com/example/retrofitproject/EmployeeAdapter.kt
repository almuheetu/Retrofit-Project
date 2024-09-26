package com.example.retrofitproject

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup

import com.example.retrofitproject.databinding.AdapterEmployeeBinding
import com.example.retrofitproject.model.EmployeeResponseItem


class EmployeeAdapter(
    private val employeeList : ArrayList<EmployeeResponseItem>

) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    companion object{
         val listener: ItemClickListener? = null
    }

    class ViewHolder(var binding: AdapterEmployeeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterEmployeeBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val employee = employeeList[position]
        viewHolder.binding.tvEmployeeName.text = employee.name
        viewHolder.itemView.setOnClickListener {
            listener?.onItemClick(employee.id)
        }
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    interface ItemClickListener {
        fun onItemClick(id: Int)
    }

}