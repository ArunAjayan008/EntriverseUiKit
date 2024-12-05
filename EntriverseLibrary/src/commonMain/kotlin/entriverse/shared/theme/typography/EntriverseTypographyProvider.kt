package entriverse.shared.theme.typography

import entriverse.shared.theme.UserLocale
import entriverse.shared.theme.dimen.EntriverseDimens

fun interface EntriverseTypographyProvider:(UserLocale,EntriverseDimens)-> EntriverseTypography {
}