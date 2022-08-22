package co.condorlabs.demo.drawer

sealed class NavDrawerItem(var route: String, var title: String) {
    object Text : NavDrawerItem("text", "Text")
    object Button : NavDrawerItem("button", "Button")
    object TextField : NavDrawerItem("text-field", "Text Field")
    object RadioGroup: NavDrawerItem("radio-group", "Radio Group")
}
