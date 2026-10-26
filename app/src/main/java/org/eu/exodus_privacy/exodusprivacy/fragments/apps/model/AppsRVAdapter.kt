package org.eu.exodus_privacy.exodusprivacy.fragments.apps.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.ListAdapter
import org.eu.exodus_privacy.exodusprivacy.R
import org.eu.exodus_privacy.exodusprivacy.databinding.RecyclerViewAppItemBinding
import org.eu.exodus_privacy.exodusprivacy.manager.database.app.ExodusApplication
import org.eu.exodus_privacy.exodusprivacy.utils.BindingHolder
import org.eu.exodus_privacy.exodusprivacy.utils.setExodusColor

class AppsRVAdapter(
    private val onAppClick: (String) -> Unit, // Callback simple qui renvoie le packageName
) : ListAdapter<ExodusApplication, BindingHolder<RecyclerViewAppItemBinding>>(AppsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<RecyclerViewAppItemBinding> {
        return BindingHolder(
            RecyclerViewAppItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: BindingHolder<RecyclerViewAppItemBinding>, position: Int) {
        val context = holder.itemView.context
        val app = getItem(position)

        holder.binding.apply {
            root.setOnClickListener {
                onAppClick(app.packageName) // On appelle simplement la lambda ici
            }
            appIconIV.background = app.icon.toDrawable(context.resources)
            appNameTV.text = app.name
            when (app.exodusVersionCode) {
                0L -> appVersionTV.apply {
                    text = context.resources.getString(R.string.version_unavailable)
                    visibility = View.VISIBLE
                }
                app.versionCode -> appVersionTV.visibility = View.GONE
                else -> appVersionTV.apply {
                    text = context.resources.getString(R.string.version_mismatch)
                    visibility = View.VISIBLE
                }
            }
            trackersChip.apply {
                val trackerNum = if (app.exodusVersionCode == 0L) "?" else app.exodusTrackers.size.toString()
                text = trackerNum
                setExodusColor(trackerNum)
            }
            permsChip.apply {
                val permsNum = app.permissions.size.toString()
                text = permsNum
                setExodusColor(permsNum)
            }
        }
    }
}
