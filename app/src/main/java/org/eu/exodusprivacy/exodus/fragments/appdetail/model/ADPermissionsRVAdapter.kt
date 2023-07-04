package org.eu.exodusprivacy.exodus.fragments.appdetail.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.eu.exodusprivacy.exodus.R
import org.eu.exodusprivacy.exodus.databinding.RecyclerViewPermissionItemBinding
import org.eu.exodusprivacy.exodus.objects.Permission

class ADPermissionsRVAdapter :
    ListAdapter<Permission, ADPermissionsRVAdapter.ViewHolder>(ADPermissionsDiffUtil()) {

    inner class ViewHolder(val binding: RecyclerViewPermissionItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerViewPermissionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val app = getItem(position)

        holder.binding.apply {
            permissionTitleTV.text = app.shortName
            permissionSubTitleTV.text = app.label.replaceFirstChar { it.uppercase() }
            if (app.description.isEmpty() || app.description == "null") {
                permissionDescTV.visibility = View.GONE
                expandBT.visibility = View.GONE
            } else {
                expandBT.setOnClickListener {
                    if (permissionDescTV.isVisible) {
                        expandBT.setIconResource(R.drawable.ic_down)
                        permissionDescTV.visibility = View.GONE
                    } else {
                        expandBT.setIconResource(R.drawable.ic_up)
                        permissionDescTV.text = app.description
                        permissionDescTV.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}
