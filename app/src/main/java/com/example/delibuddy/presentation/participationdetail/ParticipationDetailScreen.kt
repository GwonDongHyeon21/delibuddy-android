package com.example.delibuddy.presentation.participationdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.delibuddy.R
import com.example.delibuddy.navigation.home.model.HomeToDetail
import com.example.delibuddy.presentation.component.CenterCircularProgressIndicator
import com.example.delibuddy.presentation.component.CustomText3
import com.example.delibuddy.presentation.component.CustomText5
import com.example.delibuddy.presentation.component.CustomText6
import com.example.delibuddy.presentation.component.TopBar
import com.example.delibuddy.presentation.participationdetail.component.DealsMemberItem
import com.example.delibuddy.presentation.roomlist.component.TagChip
import com.example.delibuddy.ui.theme.Gray2
import com.example.delibuddy.ui.theme.InnerPadding
import com.example.delibuddy.ui.theme.MainBackground
import com.example.delibuddy.ui.theme.MainColor
import com.example.delibuddy.ui.theme.MainWhite

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ParticipationDetailScreen(
    navController: NavController,
    room: HomeToDetail,
    viewModel: ParticipationDetailViewModel = viewModel()
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val members by viewModel.members.collectAsState()
    val location by viewModel.location.collectAsState()
    val popBack by viewModel.popBack.collectAsState()
    val isDialog by viewModel.isDialog.collectAsState()
    val memberInfo = viewModel.member.collectAsState()

    LaunchedEffect(room.roomId) {
        viewModel.getRoomDetail(room.roomId)
    }
    LaunchedEffect(popBack) {
        if (popBack)
            navController.popBackStack()
    }

    Scaffold(
        topBar = { TopBar(room.roomName) { navController.popBackStack() } },
    ) {
        if (isLoading)
            Column(
                Modifier
                    .fillMaxSize()
                    .background(MainBackground)
                    .padding(it)
                    .padding(InnerPadding)
            ) {
                CustomText6("인원 현황")
                Spacer(Modifier.height(12.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MainWhite),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(members) { member ->
                            DealsMemberItem(member, viewModel)
                        }
                    }
                }

                Spacer(Modifier.height(20.dp))
                CustomText6("방 상세")
                Spacer(Modifier.height(12.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MainWhite
                    ),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        CustomText5("방 상세 설명")
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomText5("" + room.roomContent)
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomText5("방 키워드")
                        Spacer(modifier = Modifier.height(8.dp))
                        val tagList: List<String> = room.roomTagChips
                            .removeSurrounding("[", "]")
                            .split(",")
                            .map { it.trim() }
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            tagList.forEach { keyword ->
                                TagChip(keyword)
                            }
                        }
                    }
                }

//                if (!isButton) {
//                    val roomOptions = viewModel.roomOptions.collectAsState()
//                    val room = rememberSaveable { mutableStateOf("") }
//                    val roomExpanded = remember { mutableStateOf(false) }
//                    val roomInfo = Infos(
//                        "방 상태",
//                        room,
//                        room,
//                        roomOptions.value,
//                        roomExpanded,
//                        Icons.Default.KeyboardArrowDown
//                    )
//
//                    Spacer(Modifier.height(20.dp))
//                    CustomText6("방 상태")
//                    Spacer(Modifier.height(8.dp))
//                    Column {
//                        RowTextAndIcon(
//                            keyboardController = keyboardController,
//                            text = roomInfo.selectedText.value,
//                            placeholder = roomInfo.placeholder,
//                            icon = roomInfo.icon,
//                            onClickExpanded = { roomInfo.expanded.value = true }
//                        )
//                        DropDownMenu(
//                            options = roomInfo.options,
//                            isExpanded = roomInfo.expanded,
//                            onClickExpanded = { roomInfo.expanded.value = false },
//                            onClickOption = { roomInfo.selectedText.value = it }
//                        )
//                    }
//                }

                Spacer(Modifier.height(20.dp))
                CustomText6("위치")
                Spacer(Modifier.height(12.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MainWhite
                    ),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        CustomText5(location)
                    }
                }

                if (isDialog)
                    AlertDialog(
                        containerColor = MainWhite,
                        modifier = Modifier.wrapContentHeight(),
                        onDismissRequest = { viewModel.isDialogFalse() },
                        confirmButton = {},
                        dismissButton = {},
                        title = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .clickable { viewModel.isDialogFalse() }
                                )
                            }
                        },
                        text = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(20.dp)
                            ) {
                                Image(
                                    painter = painterResource(memberInfo.value.illustration),
                                    contentDescription = "User Icon",
                                    modifier = Modifier.size(120.dp)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    CustomText3(memberInfo.value.nickName)
                                    Spacer(modifier = Modifier.height(8.dp))
                                    CustomText5(memberInfo.value.univInfo[2].toString())
                                    Spacer(modifier = Modifier.height(8.dp))
                                    CustomText5(
                                        memberInfo.value.univInfo[1].toString().split(".")
                                            .first() + "학번"
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Image(
                                            painter = painterResource(R.drawable.heart_icon),
                                            contentDescription = ""
                                        )
                                        Spacer(Modifier.width(2.dp))
                                        CustomText5(memberInfo.value.favoriteCount.toString() + "개")
                                    }
                                }

                                Spacer(modifier = Modifier.height(20.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Button(
                                        onClick = { viewModel.blockUser(memberInfo.value.userId) },
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(40.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = Gray2)
                                    ) {
                                        CustomText3(text = "차단하기", alpha = 0.7f)
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Button(
                                        onClick = { viewModel.isDialogFalse() },
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(40.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = MainColor)
                                    ) {
                                        CustomText3(text = "채팅 걸기")
                                    }
                                }
                            }
                        }
                    )
            }
        else
            CenterCircularProgressIndicator()
    }
}