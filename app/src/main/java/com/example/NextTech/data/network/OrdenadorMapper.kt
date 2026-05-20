package com.example.NextTech.data.network

import com.example.NextTech.R
import com.example.NextTech.data.Ordenador

fun OrdenadorDto.toOrdenador(): Ordenador {

    val drawable = when (imagenPrincipal) {
        // Apple
        "macbook_air_m2" -> R.drawable.macbook_air_m2
        "macbook_pro_14" -> R.drawable.macbook_pro_14
        "macbook_pro_16" -> R.drawable.macbook_pro_16

        // Dell
        "dell_xps_13_9320" -> R.drawable.dell_xps_13_9320
        "dell_xps_15_9530" -> R.drawable.dell_xps_15_9530
        "dell_alienware_m16_r1" -> R.drawable.dell_alienware_m16_r1
        "dell_inspiron_15" -> R.drawable.dell_inspiron_15

        // HP
        "hp_spectre_14" -> R.drawable.hp_spectre_14
        "hp_envy_16" -> R.drawable.hp_envy_16
        "hp_omen_trascend_16" -> R.drawable.hp_omen_trascend_16
        "hp_pavilion_aero_13" -> R.drawable.hp_pavilion_aero_13

        // Lenovo
        "lenovo_thinkpad_x1_carbon_gen_11" -> R.drawable.lenovo_thinkpad_x1_carbon_gen_11
        "lenovo_yoga_9i_14" -> R.drawable.lenovo_yoga_9i_14
        "lenovo_legion_pro_7i_gen_8" -> R.drawable.lenovo_legion_pro_7i_gen_8
        "lenovo_ideapad_slim5" -> R.drawable.lenovo_ideapad_slim5

        // Asus
        "asus_rog_zephyrus_g14" -> R.drawable.asus_rog_zephyrus_g14
        "asus_zenbook_14_oled" -> R.drawable.asus_zenbook_14_oled
        "asus_proart_studiobook_16_oled" -> R.drawable.asus_proart_studiobook_16_oled
        "asus_tuf_gaming_a15" -> R.drawable.asus_tuf_gaming_a15

        // Acer
        "acer_swift_go_14" -> R.drawable.acer_swift_go_14
        "acer_predator_helios_16" -> R.drawable.acer_predator_helios_16
        "acer_aspire_5" -> R.drawable.acer_aspire_5

        // Microsoft
        "microsoft_surface_laptop_5" -> R.drawable.microsoft_surface_laptop_5
        "microsoft_surface_laptop_studio_2" -> R.drawable.microsoft_surface_laptop_studio_2

        // Razer
        "razer_blade_15" -> R.drawable.razer_blade_15

        "razer_blade_18" -> R.drawable.razer_blade_18

        // MSI
        "msi_titan_gt77_hx_gaming" -> R.drawable.msi_titan_gt77_hx_gaming
        "msi_katana_15" -> R.drawable.msi_katana_15
        "msi_prestige_14_evo" -> R.drawable.msi_prestige_14_evo

        // Samsung
        "samsung_galaxy_book3_ultra" -> R.drawable.samsung_galaxy_book3_ultra
        "samsung_galaxy_book3_pro_360" -> R.drawable.samsung_galaxy_book3_pro_360

        else -> R.drawable.ic_launcher_foreground
    }

    return Ordenador(
        id = id,
        nombre = nombre,
        imagenPrincipal = drawable,
        especificaciones = especificaciones
    )
}