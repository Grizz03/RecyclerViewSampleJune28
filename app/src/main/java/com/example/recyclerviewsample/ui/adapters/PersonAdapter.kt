package com.example.recyclerviewsample.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsample.databinding.PersonItemBinding
import com.example.recyclerviewsample.models.Person

class PersonAdapter(
    private val personList: List<Person>,
    private val listener: (person: Person) -> Unit
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personList[position])
    }

    override fun getItemCount() = personList.size

    class PersonViewHolder(
        private val binding: PersonItemBinding,
        private val listener: (person: Person) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) = with(binding) {
            nameTv.text = person.name
            nicknameTv.text = person.nickName
            ageTv.text = person.age.toString()
            isAliveTv.text = person.isAlive.toString()
            root.setOnClickListener {
                listener.invoke(person)
            }
        }
    }
}
