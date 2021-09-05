package com.example.submissionandroidpemula.core.source

import com.example.submissionandroidpemula.core.domain.model.Product

object ProductDummy {
    fun getAllProducts():List<Product> = arrayListOf(
        Product(
            id = "PRODUCT-1",
            name = "Acer Aspire",
            specification = """
                • Processor : Intel Core i5-1135G7
                • OS : Windows 10 Home
                • Memory : 8GB DDR Memory (upgradeable up to 24 GB)
                • Storage : 512GB SSD NVMe (Bundle with HDD Upgrade Kit)
                • Inch, Res, Ratio, Panel : 14" Full HD (1920 x 1080), IPS Display, high-brightness, Acer ComfyView™ LED-backlit TFT LCD, Ultra-slim design
                • Graphics : Intel® Iris® Xe Graphics 80 EU
                • Features : Power-off USB Charging, Wifi 6, Exo Amp Antenna
            """.trimIndent(),
            price = 8600000,
            description = """
                • Cakupan sinyal 360 derajat dengan Exo Amp Antenna.
                • RAM & Storage yang bisa diupgrade untuk penyimpanan lebih besar dan performa yang lebih tinggi.
                • 27% Performa lebih baik dibandingkan 10th Gen series (i5-1035G4)
            """.trimIndent(),
            stars = 4F,
            imgPath = "acer-aspire.jpg",
        ),
        Product(
            id = "PRODUCT-2",
            name = "Asus Tuf Gaming",
            specification = """
                - Processor 10th Generation Intel® Core™ i5-10300H Processor (2.50 GHz, up to 4.50 GHz with Turbo Boost, 4 Cores, 8 Thread)
                - Operating System Windows 10 Home
                - Memory 8 GB DDR4 3200MHZ ( UPTO 32GB )
                - Storage 512GB M.2 NVMe™ PCIe® 3.0 SSD
                - Graphic nVidia GTX1650 with 4GB DDR6, VRAM
                - Display 15.6inch (16:9) FHD (1920x1080) 144Hz Anti-Glare IPS-level Panel 45% NTSC
                - Keyboard Chiclet keyboard with isolated numpad key [ Backlight RGB ]
                - WebCam HD camera (Front)
                - OFFICE HOME STUDENT 2019 ORIGINAL
            """.trimIndent(),
            price = 13000000,
            description = """
                Dipersiapkan untuk gaming serius dan mengguncang gaya baru yang apik, TUF Gaming F15 adalah laptop gaming 
                Windows 10 Pro yang dilengkapi fitur dengan kekuatan untuk membawa Anda menuju kemenangan. GPU GeForce 
                RTX ™ 3060 yang baru menghadirkan gameplay yang lancar hingga layar 240Hz dengan 100% sRGB, 
                sedangkan CPU Intel® Core ™ i9-11900H yang kuat didukung oleh pendinginan yang ditingkatkan yang 
                memperkuat kinerja CPU dan menjaga akustik tetap tersembunyi. Baterai 90Wh yang tahan lama ditambah 
                dengan ketahanan kelas militer TUF membuat Anda tetap pada permainan terbaik Anda di mana saja.
            """.trimIndent(),
            stars = 4.7F,
            imgPath = "asus-tuf-gaming.jpg",
        ),
        Product(
            id = "PRODUCT-3",
            name = "Asus Vivobook",
            specification = """
                Processor : AMD Ryzen 5
                RAM : 8GB
                STORAGE : 512GB SSD
                VGA : Integrated Intel
                OS : Windows 10 home + Office Home Student 2019
                DISPLAY : 14.0 FHD
            """.trimIndent(),
            price = 8700000,
            description = """
                Dengan warna yang mencolok dan tombol Enter yang diberi warna khusus, ASUS VivoBook Ultra 15 OLED M513 
                menambah bakat dan dinamika dalam komputasi harian. Dengan prosesor AMD® Ryzen™ 5000 Series, 
                VivoBook Ultra 15 OLED memberikan daya yang Anda butuhkan untuk menyelesaikan sesuatu. VivoBook Utlra 15 OLED
                memungkinkan Anda mengekspresikan warna asli Anda, dengan layar OLED NanoEdge FHD 15 inci yang jelas dan memukau 
                serta audio bersertifikasi Harman Kardon yang menakjubkan. Laptop ini juga memiliki desain penyimpanan ganda yang 
                menggabungkan kecepatan data cepat dari SSD dengan kapasitas HDD yang besar, memberi Anda yang terbaik dari kedua 
                dunia untuk meningkatkan produktivitas.
            """.trimIndent(),
            stars = 3.5F,
            imgPath = "asus-vivobook.jpg",
        ),
        Product(
            id = "PRODUCT-4",
            name = "Dell Inspiron",
            specification = """
                10th Generation Intel® Core™ i3 processor
                Windows 10 Pro 64
                14" diagonal, HD (1366 x 768), narrow bezel, anti-glare, 250 nits, 45% NTSC
                4 GB DDR4-2666 SDRAM (1 x 4 GB)
                256 GB PCIe® NVMe™ SSD
                Budget friendly. Business ready.
                Intel® UHD Graphics
                2 Super Speed USB Type-A 5Gbps signaling rate; 1 SuperSpeed USB Type-C® 5Gbps signaling rate; 1 RJ-45; 1 headphone/microphone combo; 1 HDMI 1.4b; 1 AC power
                1 year (1/1/0) limited warranty includes 1 year of parts and labor. No on-site repair. Terms and conditions vary by country. Certain restrictions and exclusions apply.
            """.trimIndent(),
            price = 9000000,
            description = """
                14-inch laptop featuring responsive performance in a sleek design with 2-sided narrow borders, 
                optional PCIe SSDs, Express Charge1, and Intel® Core™ processors.
            """.trimIndent(),
            stars = 4.5F,
            imgPath = "dell-inspiron.jpg",
        ),
        Product(
            id = "PRODUCT-5",
            name = "HP Pavilion",
            specification = """
                • Processor :  AMD Ryzen 5 5500U processor (2.1GHz; Up To 4.0GHz; 8MB Cache)
                • OS : Windows 10 Home
                • Panel : 14″ diagonal, FHD (1920 x 1080), IPS, micro-edge, BrightView, 250 nits, 45% NTSC
                • Graphic :  AMD Radeon Graphics
                • Memory : 16 GB DDR4-3200 MHz RAM
                • Storage : 512 GB PCIe® NVMe™ M.2 SSD
                • Include Office Home & Student 2019
            """.trimIndent(),
            price = 3900000,
            description = """
                Laptop hp pavilion laptop multimedia, layar lebar, Keyboard numerik, speker mantap
            """.trimIndent(),
            stars = 2.8F,
            imgPath = "hp-pavilion.jpg",
        ),
        Product(
            id = "PRODUCT-6",
            name = "HP Probook",
            specification = """
                Processor Intel Core i5 8250U 1.60 Ghz - 1.80Ghz
                Memory DDR4 8 GB
                Disk Drive SSD 128GB NVME
                VGA Intel UHD Graphics 620
                Bluetooth,WiFi
                Port USB Tipe C
                Port HDMI,
                Port RGB VGA
                Port USB3 SS
                Mini DisplayPort
                LAN Gigabit
                Cardreader
                Keyboard Backlite Nyala
                Display Layar LED 14 Inchi Anti Glare
            """.trimIndent(),
            price = 5500000,
            description = """
                Tipe HP Probook 440 G4 pada judul, tapi G5 pada judul.

                Selagi masih di IKLAN,
                Langsung Order Bos ku

                Stock Terbatas,

                Notebook Commercial,elegan,ringan !!
            """.trimIndent(),
            stars = 3F,
            imgPath = "hp-probook.jpg",
        ),
        Product(
            id = "PRODUCT-7",
            name = "Lenovo Ideapad",
            specification = """
                Processor : AMD Ryzen 5 5500U processor (2.1GHz; Up To 4.0GHz; 8MB Cache)
                Display : 14″ FHD (1920×1080) IPS 300nits Anti-glare, 45% NTSC
                Memory : 8GB DDR4-3200MHz
                Storage : 512GB SSD M.2 2242 PCIe 3.0×4 NVMe
                Graphics : Integrated AMD Radeon Graphics
                Baterai : 3CELL 56.5WH (Up to 14 Hours)
                Others : Backlit Keyboard, Finger Print
                Oprasional System : Windows 10 Home +Office Home & Student 2019
            """.trimIndent(),
            price = 10000000,
            description = """
                Mohon Tanyakan STOK terlebih dahulu sebelum Order

                HARGA DAPAT BERUBAH SEWAKTU2
                
                TOKO OFFLINE DI BEC LT 2 BLOK K02

                SEMUA BARANG KITA RESMI GAN !! JAMINAN KUALITAS DARI PRINSIPAL
                ---Kami TIDAK MENJUAL BARANG KW dan non original---
            """.trimIndent(),
            stars = 4F,
            imgPath = "lenovo-ideapad.jpg",
        ),
        Product(
            id = "PRODUCT-8",
            name = "Lenovo Thinkpad",
            specification = """
                - proc corei5 4200u 1.60Ghz Haswell
                - Ram dan SSD dapat pilih di varian..
                - wifi
                - webcam
                - usb 3.0
                - VGA Intel HD 4400
                - Layar led 12.5 inch widescreen
                - Windows 10 siap pakai
            """.trimIndent(),
            price = 3900000,
            description = """
                NB: Garansi personal 1bulan

                *jabodetabek bisa gosend
                *Untuk Jarak jauh bisa dikirim dengan packingan aman. (bubblewrap dan kardus).

                ayo di order ..STOCK Terbatas..

                Reseller..ecer..grosir..WELCOME..

                Jangan ragu untuk bertanya atau order.

                Terima kasih.
            """.trimIndent(),
            stars = 3F,
            imgPath = "lenovo-thinkpad.jpg",
        ),
        Product(
            id = "PRODUCT-9",
            name = "Mi Notebook",
            specification = """
                Material Metal
                OS Windows 10
                CPU Type Intel Core m3 - 8100Y
                CPU Frequency 1.1GHz,Dual Core,Up to 3.4GHz
                Cache 4M
                Graphics Chipset Intel UHD Graphics 615
                RAM 4GB DDR3L
                Hard Disk Memory 128GB SSD
                Screen size 12.5 Inch
                Display Ratio 16:9
                Screen resolution 1920 x 1080 (FHD)
                Screen type IPS
                Audio video
                CD Driver Not Supported
                Battery Type 7.4V/4800mAh 5 hours video playing time
                AC adapter 110-240V 5V 2A
                Product size 29.20 x 20.20 x 1.29 cm
            """.trimIndent(),
            price = 8500000,
            description = """
                Upgrade SSD resmi ke 512gb / 256gb pilih di variant

                Garansi 7 hari ganti unit baru
                1 tahun international,

                Unit yang kami berikan yaitu Mi Notebook Air 12.5" 2019 dengan generasi terbaru, Core M3 8100y. 
                memiliki keunggulan dibandingkan generasi sebelumnya
            """.trimIndent(),
            stars = 5F,
            imgPath = "mi-notebook.jpg",
        ),
        Product(
            id = "PRODUCT-10",
            name = "Toshiba",
            specification = """
                Processor Intel(T) Core(TM) i5-3210M CPU @2.50GHz Generasi 2
                Intel(R) HD Graphics 4000
                LCD 14 Inch Resolusi 1366 X 768
                HDD 320 GB
                RAM 4 GB
                DVD
                Wifi
                Camera
            """.trimIndent(),
            price = 2700000,
            description = """
                WELCOME RESELLER DAN DROPSHIPER LAPTOP SIAP PAKAI
                Belanja Di WILAZA TECH 100% ORIGINAL PRODUKNYA , BERKUALITAS BARANGNYA , PRODUK REAL 100% & HARGA BERSAHABAT :
            """.trimIndent(),
            stars = 2F,
            imgPath = "toshiba-unveils.jpg",
        ),
    )
}