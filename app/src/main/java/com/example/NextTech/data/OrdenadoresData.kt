package com.example.NextTech.data


/**
 * Una lista predefinida de objetos [Ordenador] que sirve como fuente de datos de la aplicación.
 * Esta lista contiene varios modelos de portátiles de diferentes fabricantes como Apple, Dell, HP, etc.,
 * con todos los modelos con especificaciones detalladas para su visualización en detallesPage.
 */
/*
val ordenadores = listOf(
    // Apple
    Ordenador(
        id = "1",
        nombre = "Apple MacBook Air 13\" (M2)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador","Chip M2 de Apple con CPU de 8 núcleos y GPU de 8 núcleos"),
            Especificacion("Memoria RAM", "8 GB de memoria unificada (ampliable a 16 GB o 24 GB)"),
            Especificacion("Almacenamiento", "256 GB SSD (ampliable a 512 GB, 1 TB o 2 TB)"),
            Especificacion("Pantalla", "13,6 pulgadas Liquid Retina con True Tone, 500 nits"),
            Especificacion("Batería", "Hasta 18 horas de reproducción de vídeo"),
            Especificacion("Puertos", "Puerto de carga MagSafe 3, dos puertos Thunderbolt/USB 4"),
            Especificacion("Peso", "1,24 kg")
        )
    ),
    Ordenador(
        id = "2",
        nombre = "Apple MacBook Pro 14\" (M3 Pro)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Chip M3 Pro de Apple con CPU de hasta 12 núcleos y GPU de hasta 18 núcleos"),
            Especificacion("Memoria RAM", "18 GB de memoria unificada (ampliable a 36 GB)"),
            Especificacion("Almacenamiento", "512 GB SSD (ampliable a 1 TB, 2 TB o 4 TB)"),
            Especificacion("Pantalla", "14,2 pulgadas Liquid Retina XDR, ProMotion hasta 120 Hz"),
            Especificacion("Batería", "Hasta 18 horas de reproducción de vídeo"),
            Especificacion("Puertos", "Tres puertos Thunderbolt 4, puerto HDMI, ranura para tarjetas SDXC, MagSafe 3"),
            Especificacion("Peso", "1,61 kg")
        )
    ),
    Ordenador(
        id = "3",
        nombre = "Apple MacBook Pro 16\" (M3 Max)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Chip M3 Max de Apple con CPU de 16 núcleos y GPU de 40 núcleos"),
            Especificacion("Memoria RAM", "48 GB de memoria unificada (ampliable a 64 GB o 128 GB)"),
            Especificacion("Almacenamiento", "1 TB SSD (ampliable a 2 TB, 4 TB u 8 TB)"),
            Especificacion("Pantalla", "16,2 pulgadas Liquid Retina XDR, ProMotion hasta 120 Hz"),
            Especificacion("Batería", "Hasta 22 horas de reproducción de vídeo"),
            Especificacion("Puertos", "Tres puertos Thunderbolt 4, puerto HDMI, ranura para tarjetas SDXC, MagSafe 3"),
            Especificacion("Peso", "2,16 kg")
        )
    ),

    // Dell
    Ordenador(
        id = "4",
        nombre = "Dell XPS 13 (9320)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-1260P de 12.ª generación"),
            Especificacion("Memoria RAM", "16 GB LPDDR5 a 5200 MHz"),
            Especificacion("Almacenamiento", "512 GB SSD PCIe 4.0 x4"),
            Especificacion("Pantalla", "13,4\" FHD+ (1920 x 1200), 500 nits, InfinityEdge"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics"),
            Especificacion("Puertos", "2 puertos Thunderbolt 4 (USB Type-C)"),
            Especificacion("Peso", "1,17 kg")
        )
    ),
    Ordenador(
        id = "5",
        nombre = "Dell XPS 15 (9530)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i9-13900H de 13.ª generación"),
            Especificacion("Memoria RAM", "32 GB DDR5 a 4800 MHz"),
            Especificacion("Almacenamiento", "1 TB SSD PCIe NVMe"),
            Especificacion("Pantalla", "15,6\" OLED 3.5K (3456 x 2160) InfinityEdge táctil"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4070 con 8 GB GDDR6"),
            Especificacion("Batería", "86 Wh integrada"),
            Especificacion("Peso", "1,92 kg")
        )
    ),
    Ordenador(
        id = "6",
        nombre = "Dell Alienware m16 R1 (Gaming)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "AMD Ryzen 9 7845HX (12 núcleos, 24 hilos)"),
            Especificacion("Memoria RAM", "32 GB DDR5 a 4800 MHz"),
            Especificacion("Almacenamiento", "2 TB SSD PCIe NVMe M.2"),
            Especificacion("Pantalla", "16\" QHD+ (2560 x 1600) 240 Hz, 3 ms, ComfortView Plus"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4080 con 12 GB GDDR6"),
            Especificacion("Teclado", "AlienFX RGB por tecla"),
            Especificacion("Peso", "3,25 kg")
        )
    ),
    Ordenador(
        id = "7",
        nombre = "Dell Inspiron 15",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i5-1235U de 12.ª generación"),
            Especificacion("Memoria RAM", "8 GB DDR4 a 2666 MHz"),
            Especificacion("Almacenamiento", "256 GB SSD PCIe NVMe"),
            Especificacion("Pantalla", "15,6\" FHD (1920 x 1080), 120 Hz, WVA"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics"),
            Especificacion("Puertos", "1 USB 3.2 Gen 1, 1 USB 2.0, 1 HDMI 1.4"),
            Especificacion("Peso", "1,65 kg")
        )
    ),

    // HP
    Ordenador(
        id = "8",
        nombre = "HP Spectre x360 14",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-1355U (hasta 5,0 GHz, 10 núcleos)"),
            Especificacion("Memoria RAM", "16 GB LPDDR5-5200 MHz"),
            Especificacion("Almacenamiento", "512 GB SSD PCIe Gen4 NVMe"),
            Especificacion("Pantalla", "13,5\" 3K2K (3000 x 2000) OLED, multitáctil"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics"),
            Especificacion("Audio", "Bang & Olufsen con cuatro altavoces"),
            Especificacion("Peso", "1,36 kg")
        )
    ),
    Ordenador(
        id = "9",
        nombre = "HP Envy 16",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-13700H (hasta 5,0 GHz, 14 núcleos)"),
            Especificacion("Memoria RAM", "16 GB DDR5-5200 MHz"),
            Especificacion("Almacenamiento", "1 TB SSD PCIe Gen4 NVMe"),
            Especificacion("Pantalla", "16\" WQXGA (2560 x 1600), 120 Hz, IPS"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4060 (8 GB)"),
            Especificacion("Cámara", "HP True Vision 5MP con reducción de ruido"),
            Especificacion("Peso", "2,3 kg")
        )
    ),
    Ordenador(
        id = "10",
        nombre = "HP Omen Transcend 16 (Gaming)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i9-13900HX (hasta 5,4 GHz, 24 núcleos)"),
            Especificacion("Memoria RAM", "32 GB DDR5-5600 MHz"),
            Especificacion("Almacenamiento", "2 TB SSD PCIe Gen4 NVMe"),
            Especificacion("Pantalla", "16\" WQXGA (2560 x 1600), 240 Hz, mini-LED, 1180 nits"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4070 (8 GB)"),
            Especificacion("Puertos", "2 Thunderbolt 4, 1 HDMI 2.1, 2 USB Type-A"),
            Especificacion("Peso", "2,1 kg")
        )
    ),
    Ordenador(
        id = "11",
        nombre = "HP Pavilion Aero 13",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "AMD Ryzen 7 7735U (hasta 4,75 GHz)"),
            Especificacion("Memoria RAM", "16 GB LPDDR5-6400 MHz"),
            Especificacion("Almacenamiento", "512 GB SSD PCIe NVMe"),
            Especificacion("Pantalla", "13,3\" WUXGA (1920 x 1200), IPS, 400 nits"),
            Especificacion("Gráficos", "AMD Radeon Graphics"),
            Especificacion("Chasis", "Magnesio ligero"),
            Especificacion("Peso", "0,97 kg")
        )
    ),

    // Lenovo
    Ordenador(
        id = "12",
        nombre = "Lenovo ThinkPad X1 Carbon Gen 11",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-1355U de 13.ª generación"),
            Especificacion("Memoria RAM", "32 GB LPDDR5-6000 MHz"),
            Especificacion("Almacenamiento", "1 TB SSD M.2 2280 PCIe Gen4"),
            Especificacion("Pantalla", "14\" 2.8K (2880 x 1800), OLED, antirreflejos, 400 nits"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics integrada"),
            Especificacion("Certificación", "Intel Evo Platform"),
            Especificacion("Peso", "1,12 kg")
        )
    ),
    Ordenador(
        id = "13",
        nombre = "Lenovo Yoga 9i (14\")",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-1360P de 13.ª generación"),
            Especificacion("Memoria RAM", "16 GB LPDDR5-5200 MHz"),
            Especificacion("Almacenamiento", "512 GB SSD M.2 PCIe Gen4"),
            Especificacion("Pantalla", "14\" 2.8K (2880 x 1800) OLED, multitáctil, 90 Hz"),
            Especificacion("Sonido", "Barra de sonido giratoria con Bowers & Wilkins"),
            Especificacion("Batería", "75 Wh"),
            Especificacion("Peso", "1,4 kg")
        )
    ),
    Ordenador(
        id = "14",
        nombre = "Lenovo Legion Pro 7i Gen 8 (Gaming)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i9-13900HX de 13.ª generación"),
            Especificacion("Memoria RAM", "32 GB DDR5-5600 MHz"),
            Especificacion("Almacenamiento", "1 TB SSD M.2 2280 PCIe Gen4"),
            Especificacion("Pantalla", "16\" WQXGA (2560 x 1600), IPS, 240 Hz, 500 nits"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4080 (12 GB GDDR6)"),
            Especificacion("Refrigeración", "Legion Coldfront 5.0 con metal líquido"),
            Especificacion("Peso", "2,8 kg")
        )
    ),
    Ordenador(
        id = "15",
        nombre = "Lenovo IdeaPad Slim 5",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "AMD Ryzen 5 7530U"),
            Especificacion("Memoria RAM", "16 GB DDR4-3200 MHz"),
            Especificacion("Almacenamiento", "512 GB SSD M.2 PCIe Gen4"),
            Especificacion("Pantalla", "14\" WUXGA (1920 x 1200), IPS, 300 nits"),
            Especificacion("Gráficos", "AMD Radeon Graphics integrada"),
            Especificacion("Puertos", "2 USB-C 3.2 Gen 1, 2 USB 3.2 Gen 1, HDMI 1.4b"),
            Especificacion("Peso", "1,46 kg")
        )
    ),

    // Asus
    Ordenador(
        id = "16",
        nombre = "Asus ROG Zephyrus G14 (Gaming)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "AMD Ryzen 9 7940HS (8 núcleos, 16 hilos)"),
            Especificacion("Memoria RAM", "16 GB DDR5 a 4800 MHz"),
            Especificacion("Almacenamiento", "1 TB SSD PCIe 4.0 NVMe M.2"),
            Especificacion("Pantalla", "14\" QHD+ (2560 x 1600) ROG Nebula Display, 165 Hz"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4060 (8 GB GDDR6)"),
            Especificacion("Extras", "Pantalla AniMe Matrix opcional en tapa"),
            Especificacion("Peso", "1,72 kg")
        )
    ),
    Ordenador(
        id = "17",
        nombre = "Asus Zenbook 14 OLED",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-1360P de 13.ª generación"),
            Especificacion("Memoria RAM", "16 GB LPDDR5 integrada"),
            Especificacion("Almacenamiento", "1 TB SSD PCIe 4.0 NVMe"),
            Especificacion("Pantalla", "14\" 2.8K (2880 x 1800) OLED, 90 Hz, 550 nits HDR"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics"),
            Especificacion("Certificación", "Intel Evo Platform"),
            Especificacion("Peso", "1,39 kg")
        )
    ),
    Ordenador(
        id = "18",
        nombre = "Asus ProArt Studiobook 16",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i9-13980HX de 13.ª generación"),
            Especificacion("Memoria RAM", "64 GB DDR5 a 4800 MHz"),
            Especificacion("Almacenamiento", "2 TB SSD PCIe 4.0 NVMe M.2 (RAID 0)"),
            Especificacion("Pantalla", "16\" 3.2K (3200 x 2000) OLED, 120 Hz, Calibrada Calman"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4070 (8 GB GDDR6)"),
            Especificacion("Control", "ASUS Dial integrado"),
            Especificacion("Peso", "2,4 kg")
        )
    ),
    Ordenador(
        id = "19",
        nombre = "Asus TUF Gaming A15",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "AMD Ryzen 7 7735HS (8 núcleos, 16 hilos)"),
            Especificacion("Memoria RAM", "16 GB DDR5 a 4800 MHz"),
            Especificacion("Almacenamiento", "512 GB SSD PCIe 4.0 NVMe M.2"),
            Especificacion("Pantalla", "15,6\" FHD (1920 x 1080), 144 Hz, IPS-level"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4050 (6 GB GDDR6)"),
            Especificacion("Durabilidad", "Grado militar MIL-STD-810H"),
            Especificacion("Peso", "2,2 kg")
        )
    ),

    // Acer
    Ordenador(
        id = "20",
        nombre = "Acer Swift Go 14",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-13700H de 13.ª generación"),
            Especificacion("Memoria RAM", "16 GB LPDDR5"),
            Especificacion("Almacenamiento", "512 GB SSD PCIe Gen4"),
            Especificacion("Pantalla", "14\" 2.8K (2880 x 1800) OLED, 90 Hz, 500 nits"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics"),
            Especificacion("Cámara", "QHD 1440p con tecnología TNR"),
            Especificacion("Peso", "1,25 kg")
        )
    ),
    Ordenador(
        id = "21",
        nombre = "Acer Predator Helios 16 (Gaming)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i9-13900HX de 13.ª generación"),
            Especificacion("Memoria RAM", "32 GB DDR5 a 5600 MHz"),
            Especificacion("Almacenamiento", "1 TB SSD PCIe Gen4 NVMe"),
            Especificacion("Pantalla", "16\" WQXGA (2560 x 1600) IPS, 240 Hz, 500 nits"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4080 (12 GB GDDR6)"),
            Especificacion("Teclado", "Retroiluminación RGB por tecla"),
            Especificacion("Peso", "2,7 kg")
        )
    ),
    Ordenador(
        id = "22",
        nombre = "Acer Aspire 5",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i5-1335U de 13.ª generación"),
            Especificacion("Memoria RAM", "8 GB DDR4 (ampliable a 32 GB)"),
            Especificacion("Almacenamiento", "512 GB SSD PCIe NVMe"),
            Especificacion("Pantalla", "15,6\" FHD (1920 x 1080) IPS, ComfyView"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics"),
            Especificacion("Conectividad", "Wi-Fi 6E, Bluetooth 5.1"),
            Especificacion("Peso", "1,77 kg")
        )
    ),

    // Microsoft
    Ordenador(
        id = "23",
        nombre = "Microsoft Surface Laptop 5",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-1255U de 12.ª generación"),
            Especificacion("Memoria RAM", "16 GB LPDDR5x"),
            Especificacion("Almacenamiento", "512 GB SSD extraíble"),
            Especificacion("Pantalla", "13,5\" PixelSense (2256 x 1504) táctil, Gorilla Glass 5"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics"),
            Especificacion("Batería", "Hasta 18 horas de uso típico"),
            Especificacion("Peso", "1,29 kg")
        )
    ),
    Ordenador(
        id = "24",
        nombre = "Microsoft Surface Laptop Studio 2",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-13700H de 13.ª generación"),
            Especificacion("Memoria RAM", "32 GB LPDDR5x"),
            Especificacion("Almacenamiento", "1 TB SSD"),
            Especificacion("Pantalla", "14,4\" PixelSense Flow (2400 x 1600) táctil, 120 Hz"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4050 (6 GB GDDR6)"),
            Especificacion("Puertos", "2 USB-C con Thunderbolt 4, Surface Connect, lector microSDXC"),
            Especificacion("Peso", "1,98 kg")
        )
    ),

    // Razer
    Ordenador(
        id = "25",
        nombre = "Razer Blade 15 (Gaming)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-13800H de 13.ª generación"),
            Especificacion("Memoria RAM", "16 GB DDR5 a 5200 MHz"),
            Especificacion("Almacenamiento", "1 TB SSD PCIe Gen4 M.2"),
            Especificacion("Pantalla", "15,6\" QHD (2560 x 1440) 240 Hz, 100% DCI-P3"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4070 (8 GB GDDR6)"),
            Especificacion("Chasis", "Aluminio fresado por CNC"),
            Especificacion("Peso", "2,01 kg")
        )
    ),
    Ordenador(
        id = "26",
        nombre = "Razer Blade 18 (Gaming)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i9-13980HX de 13.ª generación"),
            Especificacion("Memoria RAM", "32 GB DDR5 a 5600 MHz"),
            Especificacion("Almacenamiento", "1 TB SSD PCIe Gen4 M.2"),
            Especificacion("Pantalla", "18\" QHD+ (2560 x 1600) 240 Hz, G-Sync, 100% DCI-P3"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4080 (12 GB GDDR6)"),
            Especificacion("Sonido", "Sistema de 6 altavoces con THX Spatial Audio"),
            Especificacion("Peso", "3,1 kg")
        )
    ),

    // MSI
    Ordenador(
        id = "27",
        nombre = "MSI Titan GT77 HX (Gaming)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i9-13980HX de 13.ª generación"),
            Especificacion("Memoria RAM", "64 GB DDR5 (4 slots, ampliable a 128 GB)"),
            Especificacion("Almacenamiento", "2 TB SSD PCIe Gen4x4 (1 slot Gen5 disponible)"),
            Especificacion("Pantalla", "17,3\" 4K (3840 x 2160) Mini-LED, 144 Hz, HDR 1000"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4090 (16 GB GDDR6)"),
            Especificacion("Teclado", "Cherry MX Ultra Low Profile Mechanical RGB"),
            Especificacion("Peso", "3,3 kg")
        )
    ),
    Ordenador(
        id = "28",
        nombre = "MSI Katana 15 (Gaming)",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-13620H de 13.ª generación"),
            Especificacion("Memoria RAM", "16 GB DDR5 a 4800 MHz"),
            Especificacion("Almacenamiento", "1 TB SSD PCIe NVMe"),
            Especificacion("Pantalla", "15,6\" FHD (1920 x 1080), 144 Hz, IPS-level"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4060 (8 GB GDDR6)"),
            Especificacion("Refrigeración", "Cooler Boost 5 con diseño de tubería compartida"),
            Especificacion("Peso", "2,25 kg")
        )
    ),
    Ordenador(
        id = "29",
        nombre = "MSI Prestige 14 Evo",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-13700H de 13.ª generación"),
            Especificacion("Memoria RAM", "16 GB LPDDR5 integrada"),
            Especificacion("Almacenamiento", "512 GB SSD PCIe Gen4x4 NVMe"),
            Especificacion("Pantalla", "14\" FHD+ (1920 x 1200), IPS-level, 100% sRGB"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics"),
            Especificacion("Certificación", "Intel Evo Platform"),
            Especificacion("Peso", "1,49 kg")
        )
    ),

    // Samsung
    Ordenador(
        id = "30",
        nombre = "Samsung Galaxy Book3 Ultra",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i9-13900H de 13.ª generación"),
            Especificacion("Memoria RAM", "32 GB LPDDR5"),
            Especificacion("Almacenamiento", "1 TB SSD PCIe NVMe"),
            Especificacion("Pantalla", "16\" 3K (2880 x 1800) Dynamic AMOLED 2X, 120 Hz"),
            Especificacion("Gráficos", "NVIDIA GeForce RTX 4070 (8 GB GDDR6)"),
            Especificacion("Ecosistema", "Integración fluida con Galaxy (S Pen, Tablet)"),
            Especificacion("Peso", "1,79 kg")
        )
    ),
    Ordenador(
        id = "31",
        nombre = "Samsung Galaxy Book3 Pro 360",
        imagenUrl = "http://10.0.2.2:5131/images/1",
        especificaciones = listOf(
            Especificacion("Procesador", "Intel Core i7-1360P de 13.ª generación"),
            Especificacion("Memoria RAM", "16 GB LPDDR5"),
            Especificacion("Almacenamiento", "512 GB SSD PCIe NVMe"),
            Especificacion("Pantalla", "16\" 3K (2880 x 1800) Dynamic AMOLED 2X, táctil"),
            Especificacion("Gráficos", "Intel Iris Xe Graphics"),
            Especificacion("Extras", "S Pen incluido, diseño 2 en 1"),
            Especificacion("Peso", "1,66 kg")
        )
    )
)


 */