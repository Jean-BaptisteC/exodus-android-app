package org.eu.exodusprivacy.exodus.fragments.appdetail.model

import androidx.recyclerview.widget.DiffUtil
import org.eu.exodusprivacy.exodus.objects.Permission

class ADPermissionsDiffUtil : DiffUtil.ItemCallback<Permission>() {
    override fun areItemsTheSame(oldItem: Permission, newItem: Permission): Boolean {
        return oldItem.shortName == newItem.shortName
    }

    override fun areContentsTheSame(oldItem: Permission, newItem: Permission): Boolean {
        return when {
            oldItem.shortName != newItem.shortName -> false
            oldItem.label != newItem.label -> false
            oldItem.description != newItem.description -> false
            else -> true
        }
    }
}
