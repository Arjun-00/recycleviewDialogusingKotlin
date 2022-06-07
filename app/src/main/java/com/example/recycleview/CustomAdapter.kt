package com.example.recycleview
import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class CustomAdapter(var userList: ArrayList<Student>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycle_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

        val views = itemView
        fun bindItems(student: Student) {
            val stdname = itemView.findViewById<TextView>(R.id.stdname)
            val stdemail = itemView.findViewById<TextView>(R.id.stdemail)
            val stdage = itemView.findViewById<TextView>(R.id.age)
            stdname.text = student.name
            stdemail.text = student.email
            stdage.text = student.age.toString()

            views.setOnClickListener(View.OnClickListener {
                showResetPasswordDialog(student.name,student.email,student.age)
                Toast.makeText(
                    views.context,
                    "Name: " + student.name + "/n Address: " +student.email,Toast.LENGTH_LONG).show()
            })
        }
            fun showResetPasswordDialog(name: String, email: String, age: Int,) {
                val dialog = Dialog(views.context)

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setCancelable(false)
                dialog.setContentView(R.layout.dialog_box)

                val dl_name = dialog.findViewById<TextView>(R.id.dialog_name)
                val dl_email = dialog.findViewById<TextView>(R.id.dialog_gmail)
                val dl_age = dialog.findViewById<TextView>(R.id.dialog_age)
                val dl_button = dialog.findViewById<TextView>(R.id.dialog_button)
                dl_name.text = name
                dl_email.text = email
                dl_age.text = age.toString()

                dl_button.setOnClickListener {
                    dialog.dismiss()
                }
                dialog.show()
            }

    }
}