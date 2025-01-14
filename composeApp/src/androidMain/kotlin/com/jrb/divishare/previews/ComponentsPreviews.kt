package com.jrb.divishare.previews


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jrb.divishare.ui.components.BackToolbar
import com.jrb.divishare.ui.components.BottomBar
import com.jrb.divishare.ui.components.DateDialog
import com.jrb.divishare.ui.components.EmailTextField
import com.jrb.divishare.ui.components.EmptyScreen
import com.jrb.divishare.ui.components.LoginToolbar
import com.jrb.divishare.ui.components.NavigationSideBar
import com.jrb.divishare.ui.components.PasswordTextField
import com.jrb.divishare.ui.components.PhoneTextField
import com.jrb.divishare.ui.components.ProjectItem
import com.jrb.divishare.ui.components.TextButton
import com.jrb.divishare.ui.components.TextButtonBox
import com.jrb.divishare.ui.components.ToolBar
import com.jrb.divishare.ui.data.ItemBottomNav
import divishare_kmm.composeapp.generated.resources.Res
import divishare_kmm.composeapp.generated.resources.ic_project_cocktail
import divishare_kmm.composeapp.generated.resources.no_results_ilustration


@Composable
@Preview(showBackground = true)
fun TextFieldPreview(){
    MaterialTheme{
        var emailText by remember { mutableStateOf(TextFieldValue("")) }
        EmailTextField(emailText, {emailText = it})
    }
}

@Composable
@Preview(showBackground = true)
fun PassTextFieldPreview(){
    MaterialTheme{
        var pass by remember { mutableStateOf(TextFieldValue("")) }
        PasswordTextField(pass, {pass = it}, false)
    }
}

@Composable
@Preview(showBackground = true)
fun PhoneNumberTextFieldPreview(){
    MaterialTheme{
        var prefix by remember { mutableStateOf(TextFieldValue("")) }
        var number by remember { mutableStateOf(TextFieldValue("")) }
        PhoneTextField(prefix, number, {prefix = it}, {number = it})
    }
}

@Composable
@Preview()
fun LoginToolbarPreview(){
    MaterialTheme{
        LoginToolbar()
    }
}

@Composable
@Preview(showBackground = true)
fun MainToolbarPreview(){
    MaterialTheme{
        ToolBar({}, {})
    }
}

@Composable
@Preview(showBackground = true)
fun BackToolbarPreview(){
    MaterialTheme{
        BackToolbar("Create Account", {})
    }
}

@Composable
@Preview()
fun MainButtonPreview(){
    MaterialTheme{
        TextButton(Modifier.width(180.dp).height(50.dp),"Log In"){}
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview()
fun TextButtonPreview(){
    MaterialTheme{
        TextButtonBox(Modifier.width(180.dp).height(40.dp), "Log In", mutableStateOf(false)){}
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview()
fun DateDialogPreview(){
    MaterialTheme{
        DateDialog(mutableStateOf(true), mutableStateOf(""))
    }
}


@Composable
@Preview()
fun ProjectItemPreview(){
    MaterialTheme{
        ProjectItem("Project Name", Res.drawable.ic_project_cocktail){}
    }
}

@Composable
@Preview(showBackground = true)
fun EmptyScreenPreview() {
    MaterialTheme {
        EmptyScreen(
            "No shared expenses available",
            "Tap on “+”  on the top toolbar to create a new shared expenses project",
            Res.drawable.no_results_ilustration)
    }
}

@Composable
@Preview(showBackground = true)
fun BottomBarPreview() {
    MaterialTheme {
        val list = listOf(ItemBottomNav.Home, ItemBottomNav.Calculator, ItemBottomNav.Settings)
        BottomBar(list, "home") { }
    }
}

@Composable
@Preview(showBackground = true)
fun SideBarPreview() {
    MaterialTheme {
        val list = listOf(ItemBottomNav.Home, ItemBottomNav.Calculator, ItemBottomNav.Settings)
        NavigationSideBar(list, "home") { }
    }
}



