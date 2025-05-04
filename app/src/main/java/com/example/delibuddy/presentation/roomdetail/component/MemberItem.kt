package com.example.delibuddy.presentation.roomdetail.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.delibuddy.presentation.component.CustomText3
import com.example.delibuddy.presentation.roomdetail.RoomDetailViewModel
import com.example.delibuddy.presentation.roomdetail.model.Member

@SuppressLint("ResourceType")
@Composable
fun MemberItem(member: Member, viewModel: RoomDetailViewModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(
            interactionSource = null,
            indication = null,
            onClick = { viewModel.getUserDetail(member.userId) }
        )
    ) {
        Image(
            painter = painterResource(member.illustration),
            contentDescription = member.nickName,
            modifier = Modifier.size(40.dp)
        )
        Spacer(Modifier.width(8.dp))
        Row(modifier = Modifier.fillMaxWidth(0.3f)) { CustomText3(member.nickName) }
        Text(text = member.department)
    }
}