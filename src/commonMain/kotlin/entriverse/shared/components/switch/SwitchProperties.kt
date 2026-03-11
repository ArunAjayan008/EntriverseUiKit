package entriverse.shared.components.switch

enum class SwitchVisualState {
    Inactive,
    Active,
    PressedInactive,
    PressedActive,
    DisabledInactive,
    DisabledActive
}

data class SwitchProps(
    val checked: Boolean = false,
    val enabled: Boolean = true,
    val pressed: Boolean = false,
    val hasIcon: Boolean = false,
    val size: SwitchSize = SwitchSize.Regular
) {
    val visualState: SwitchVisualState
        get() = when {
            !enabled && checked -> SwitchVisualState.DisabledActive
            !enabled && !checked -> SwitchVisualState.DisabledInactive
            pressed && checked -> SwitchVisualState.PressedActive
            pressed && !checked -> SwitchVisualState.PressedInactive
            checked -> SwitchVisualState.Active
            else -> SwitchVisualState.Inactive
        }
} 