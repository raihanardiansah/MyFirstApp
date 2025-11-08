package com.example.myfirstapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(private val dataList: List<Mahasiswa>)
    : RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row_mahasiswa, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val mahasiswa = dataList[position]
        holder.tvNama.text = mahasiswa.nama
        holder.tvNim.text = mahasiswa.nim

        holder.itemView.setOnClickListener {
            Toast.makeText(it.context, "Nama: ${mahasiswa.nama} NIM: ${mahasiswa.nim}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama_mahasiswa)
        val tvNim: TextView = itemView.findViewById(R.id.tv_nim_mahasiswa)
    }

}