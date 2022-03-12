package com.example.adoptame.script

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.adoptame.R
import com.example.adoptame.model.Categories
import com.example.adoptame.model.Place
import com.example.adoptame.viewmodel.CategoriesViewModel
import com.example.adoptame.viewmodel.PlaceViewModel
import kotlinx.android.synthetic.main.activity_mostrar_datos.*



class ScriptDataActivity : AppCompatActivity() {

    private lateinit var mCategoriesViewModel: CategoriesViewModel

    private lateinit var mPlaceViewModel: PlaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)

        mCategoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        mPlaceViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)

        btn_create_category.setOnClickListener {
            runAddCategories()
            runAddCategories1()
            runAddCategories2()
            runAddCategories3()
            runAddCategories4()
            runAddPlaces()
        }


        back_pressed.setOnClickListener {
            super.onBackPressed()
        }
    }

    //simple to create category
    fun runAddCategories() {
        val name = "Restaurantes"
        val desc = "Los mejores lugares para disfrutar comida típica"
        val image = "restaurant_image"
        val color = "#d4cbe5"
        val category = Categories(0, name, desc, image, color)
        mCategoriesViewModel.addCategory(category)
        Toast.makeText(this, "Create category 1 ", Toast.LENGTH_SHORT).show()
    }

    //simple to create category
    fun runAddCategories1() {
        val name1 = "Parques"
        val desc1 = "Los mejores parques de la ciudad"
        val image1 = "categories_park_icon"
        val color1 = "#947AE8"
        val category1 = Categories(0, name1, desc1, image1, color1)
        mCategoriesViewModel.addCategory(category1)
        Toast.makeText(this, "Create category 2 ", Toast.LENGTH_SHORT).show()
    }

    //simple to create category
    fun runAddCategories2() {
        val name2 = "Hoteles"
        val desc2 = "Los mejores lugares para descansar"
        val image2 = "hotel_image"
        val color2 = "#7adccf"
        val category2 = Categories(0, name2, desc2, image2, color2)
        mCategoriesViewModel.addCategory(category2)
        Toast.makeText(this, "Create category 3", Toast.LENGTH_SHORT).show()
    }

    //simple to create category
    fun runAddCategories3() {
        val name3 = "Lugares Famosos"
        val desc3 = "Lugares con historia en la ciudad"
        val image3 = "famosos_icono"
        val color3 = "#f7c59f"
        val category3 = Categories(0, name3, desc3, image3, color3)
        mCategoriesViewModel.addCategory(category3)
        Toast.makeText(this, "Create category 4", Toast.LENGTH_SHORT).show()
    }

    //simple to create category
    fun runAddCategories4() {
        val name4 = "Recomendaciones"
        val desc4 = "There are alot mall around here"
        val image4 = "recomendaciones_icono"
        val color4 = "#b8d7f5"
        val category4 = Categories(0, name4, desc4, image4, color4)
        mCategoriesViewModel.addCategory(category4)
        Toast.makeText(this, "Create category 5", Toast.LENGTH_SHORT).show()
    }

    //Simple input Place to table
    fun runAddPlaces() {
        val place_name = "La Casa de los Geranios Restaurante"
        val place_desc = "Sea usted bienvenido a este espacio de tradición que ha perdurado en el tiempo."
        val phone = " 02 2956 035"
        val address = "Morales OE1-134 y Guayaquil, Barrio La Ronda. Quito - Ecuador"
        val star_point = "4.5"
        val feature = 1
        val open_time = "10:00am"
        val close_time = "23:00pm"
        val day_open = "L-M-M-J-V-S-F-D"
        val day_close = "No"
        val image_url = "http://www.casalosgeranios.com.ec/wp-content/uploads/2017/11/IMG_6566.jpg"
        val map_url = "https://www.google.com/maps/place/La+Casa+de+los+Geranios+Restaurante/@-0.225031,-78.513573,17z/data=!4m5!3m4!1s0x0:0x9b20756b3adf1280!8m2!3d-0.2250307!4d-78.5135734?hl=es-ES"
        val website = "http://www.casalosgeranios.com.ec/"
        val review = "Muy agradable.  Excelente servicio.  Los platillos sabrosos y de buena calidad, muy bien presentados."
        val category_id = 1
        val place = Place(
            0,
            place_name,
            place_desc,
            phone,
            address,
            star_point,
            feature,
            open_time,
            close_time,
            day_open,
            day_close,
            image_url,
            map_url,
            website,
            review,
            category_id
        )

        val place_name1 = "Los Pinchos de langostino América"
        val place_desc1 = "¡No lo pienses más, ven y disfruta de algo original!"
        val phone1 = "098 466 0892"
        val address1 = "Av. América y, Abelardo Moncayo, Quito"
        val star_point1 = "4.4"
        val feature1 = 1
        val open_time1 = "12:00pm"
        val close_time1 = "22:00pm"
        val day_open1 = "L-M-M-J-V-S-D"
        val day_close1 = "No"
        val image_url1 = "http://www.lospinchosdelangostino.com/assets/img/galeriaProductos/10.png"
        val map_url1 = "https://www.google.com/maps/place/Los+Pinchos+De+Langostino/@-0.162048,-78.481896,16z/data=!4m5!3m4!1s0x0:0xde1678ae109b5c91!8m2!3d-0.1620477!4d-78.4818965?hl=es-ES"
        val website1 = "http://www.lospinchosdelangostino.com/"
        val review1 = "Platos muy buenos y acorde con los precios."
        val category_id1 = 1
        val place1 = Place(
            0,
            place_name1,
            place_desc1,
            phone1,
            address1,
            star_point1,
            feature1,
            open_time1,
            close_time1,
            day_open1,
            day_close1,
            image_url1,
            map_url1,
            website1,
            review1,
            category_id1
        )

        val place_name3 = "Biloxi Comida Tipica shyris"
        val place_desc3 = "La Fritada más deliciosa. Un clásico de todos los tiempos, un sabor que nos trae muchos recuerdos, pero sobre todo alegría y felicidad. "
        val phone3 = "(02) 244-6824"
        val address3 = "Av. de los Shyris N39-274, Quito 170135"
        val star_point3 = "4.4"
        val feature3 = 1
        val open_time3 = "9:30am"
        val close_time3 = "17:30pm"
        val day_open3 = "L-M-M-J-V-S-D"
        val day_close3 = "No"
        val image_url3 = "https://scontent.fuio1-1.fna.fbcdn.net/v/t39.30808-6/273026718_4894457087288802_4995006075028278292_n.png?_nc_cat=104&ccb=1-5&_nc_sid=e3f864&_nc_ohc=-iUkT9rkSIIAX96WnBB&_nc_ht=scontent.fuio1-1.fna&oh=00_AT_UPlJGsATR2E9m1pklKQgrAyyKugWiC3MC2t4u7f0x4Q&oe=622023E6"
        val map_url3 = "https://www.google.com/maps/place/Biloxi+Comida+Tipica+shyris/@-0.1706329,-78.4818866,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59a9c148da8ab:0x97596c1a68f1a54d!8m2!3d-0.1706329!4d-78.4796979"
        val website3 = "https://es-la.facebook.com/biloxicomidatipica/"
        val review3 = "Un lugar de lo mejor para disfrutar de comida típica, tiene gran variedad de platos y el servicio es muy bueno"
        val category_id3 = 1
        val place3 = Place(
            0,
            place_name3,
            place_desc3,
            phone3,
            address3,
            star_point3,
            feature3,
            open_time3,
            close_time3,
            day_open3,
            day_close3,
            image_url3,
            map_url3,
            website3,
            review3,
            category_id3
        )

        val place_name4 = "Parque El Ejido"
        val place_desc4 = "El parque El Ejido es un espacio verde de carácter público en la ciudad de Quito, capital de Ecuador"
        val phone4 = "No Phone"
        val address4 = "Av. 10 de Agosto, Av. Patria, Av. 6 de Diciembre & Calle Tarqui."
        val star_point4 = "4.1"
        val feature4 = 0
        val open_time4 = "24hrs"
        val close_time4 = "No"
        val day_open4 = "L-M-M-J-V"
        val day_close4 = "No"
        val image_url4 = "https://ec.viajandox.com/uploads/attractive_240.jpg"
        val map_url4 = "https://www.google.com/maps/place/Parque+El+Ejido/@-0.209149,-78.5008372,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59a3d7c9b519b:0xa3a3acdde6a3a01c!8m2!3d-0.209149!4d-78.4986485"
        val website4 = "https://www.quito.gob.ec/"
        val review4 = "Un lindo parque, para darse una buena caminata"
        val category_id4 = 2
        val place4 = Place(
            0,
            place_name4,
            place_desc4,
            phone4,
            address4,
            star_point4,
            feature4,
            open_time4,
            close_time4,
            day_open4,
            day_close4,
            image_url4,
            map_url4,
            website4,
            review4,
            category_id4
        )

        val place_name5 = "Parque Itchimbía"
        val place_desc5 = "Parque boscoso con rutas de senderismo y un invernadero del siglo XIX con árboles y orquídeas poco comunes."
        val phone5 = "No Phone"
        val address5 = "José María Aguirre N4-108 y Concepción (barrios El Dorado / La Tola)"
        val star_point5 = "4.6"
        val feature5 = 1
        val open_time5 = "6:00am"
        val close_time5 = "17:00pm"
        val day_open5 = "L-M-M-J-V-S-D"
        val day_close5 = "No"
        val image_url5 = "https://atahualpa.com/wp-content/uploads/Parque-Itchimbia.jpg"
        val map_url5 = "https://www.google.com/maps/place/Parque+Itchimb%C3%ADa/@-0.2223173,-78.5012876,17z/data=!3m1!4b1!4m5!3m4!1s0x91d5998b209471ad:0x58169710cefa9ade!8m2!3d-0.2223173!4d-78.4990989"
        val website5 = "http://www.epmmop.gob.ec/epmmop/"
        val review5 = "Gran parque lleno de árboles, que alberga senderos, exposiciones de arte y vendedores de comida y artesanías"
        val category_id5 = 2
        val place5 = Place(
            0,
            place_name5,
            place_desc5,
            phone5,
            address5,
            star_point5,
            feature5,
            open_time5,
            close_time5,
            day_open5,
            day_close5,
            image_url5,
            map_url5,
            website5,
            review5,
            category_id5
        )

        val place_name6 = "Parque La Carolina"
        val place_desc6 = "El parque La Carolina es un espacio verde de carácter público en la ciudad de Quito, capital de la República del Ecuador"
        val phone6 = "No Phone"
        val address6 = "Av. de los Shyris, Quito 170135"
        val star_point6 = "4.5"
        val feature6 = 1
        val open_time6 = "24hrs"
        val close_time6 = "No"
        val day_open6 = "L-M-M-J-V-S-D"
        val day_close6 = "No"
        val image_url6 = "https://quiteñisimo.com/wp-content/uploads/2021/05/parque-la-carolina-quito.jpg"
        val map_url6 = "https://www.google.com/maps/place/Parque+La+Carolina/@-0.1813713,-78.4864656,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59a87ac56537d:0x56b246bdb3f6ad13!8m2!3d-0.1813713!4d-78.4842769"
        val website6 = "https://www.quito.gob.ec/"
        val review6 = "Gran parque con un estanque con botes de remo, donde son populares el ciclismo, el fútbol y el baloncesto."
        val category_id6 = 2
        val place6 = Place(
            0,
            place_name6,
            place_desc6,
            phone6,
            address6,
            star_point6,
            feature6,
            open_time6,
            close_time6,
            day_open6,
            day_close6,
            image_url6,
            map_url6,
            website6,
            review6,
            category_id6
        )

        val place_name7 = "Swissôtel Quito"
        val place_desc7 = "Las elegantes habitaciones cuentan con vistas a la ciudad o a la montaña, Wi-Fi gratuito, TV de pantalla plana, minibar y caja de seguridad."
        val phone7 = "(02) 256-7600"
        val address7 = "Ave 12 de Octubre 1820 y, Quito 170525"
        val star_point7 = "4.7"
        val feature7 = 1
        val open_time7 = "No disponible"
        val close_time7 = "No disponible"
        val day_open7 = "No disponible"
        val day_close7 = "No disponible"
        val image_url7 = "https://www.swissotel.es/assets/0/92/2119/2236/2275/2277/6442451818/08ffa6a2-2e44-4163-87b3-d13a3a387ddb.jpg"
        val map_url7 = "https://www.google.com/maps/place/Swiss%C3%B4tel+Quito/@-0.2052395,-78.4876498,17z/data=!3m1!4b1!4m8!3m7!1s0x91d59a0dec20b09f:0x14d611e35be667c0!5m2!4m1!1i2!8m2!3d-0.2052395!4d-78.4854611"
        val website7 = "https://www.swissotel.es/hotels/quito/"
        val review7 = "Las habitaciones exclusivas para miembros del club ofrecen acceso a un salón con comidas gratis. "
        val category_id7 = 3
        val place7 = Place(
            0,
            place_name7,
            place_desc7,
            phone7,
            address7,
            star_point7,
            feature7,
            open_time7,
            close_time7,
            day_open7,
            day_close7,
            image_url7,
            map_url7,
            website7,
            review7,
            category_id7
        )

        val place_name9 = "Wyndham Garden Quito"
        val place_desc9 = "Este tranquilo hotel se encuentra en una calle concurrida"
        val phone9 = "(703) 590-2500"
        val address9 = "Alemania E5 103, Quito 170146"
        val star_point9 = "4.6"
        val feature9 = 1
        val open_time9 = "No disponible"
        val close_time9 = "No disponible"
        val day_open9 = "No disponible"
        val day_close9 = "No disponible"
        val image_url9 = "https://www.wyndhamhotels.com/content/dam/property-images/en-us/gn/ec/others/quito/11160/11160_exterior_day_2.jpg?downsize=1800:*"
        val map_url9 = "https://www.google.com/maps/place/Wyndham+Garden+Quito/@-0.1862247,-78.4901277,17z/data=!3m1!4b1!4m8!3m7!1s0x91d59a63161ce4d1:0xacc2a166fff40a33!5m2!4m1!1i2!8m2!3d-0.1862247!4d-78.487939"
        val website9 = "https://www.wyndhamhotels.com/es-xl"
        val review9 = "Los servicios de cortesía incluyen estacionamiento, hidromasaje y gimnasio. También hay una sala, un luminoso bar/salón y un restaurante refinado con patio. Se ofrece un desayuno tipo bufé."
        val category_id9 = 3
        val place9 = Place(
            0,
            place_name9,
            place_desc9,
            phone9,
            address9,
            star_point9,
            feature9,
            open_time9,
            close_time9,
            day_open9,
            day_close9,
            image_url9,
            map_url9,
            website9,
            review9,
            category_id9
        )

        val place_name10 = "Ciudad Mitad del Mundo"
        val place_desc10 = "La Ciudad Mitad del Mundo es un terreno propiedad de la prefectura de la provincia de Pichincha."
        val phone10 = "No Phone"
        val address10 = "Av. Manuel Córdova Galarza SN, Quito"
        val star_point10 = "4.7"
        val feature10 = 0
        val open_time10 = "9:00am"
        val close_time10 = "18:00pm"
        val day_open10 = "L-M-M-J-V-S-D"
        val day_close10 = "No"
        val image_url10 = "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/df/13/e9.jpg"
        val map_url10 = "https://www.google.com/maps/dir//mitad+del+mundo/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x91d5881ef89bad91:0xb2e1699b00a1a9b8?sa=X&ved=2ahUKEwiYve6Fjp72AhX8RzABHdR0BWMQ9Rd6BAgSEAQ"
        val website10 = "http://www.mitaddelmundo.gob.ec/es/"
        val review10 = "Monumento de piedra en el ecuador y una plaza en la que los visitantes pueden poner un pie en cada hemisferio."
        val category_id10 = 5
        val place10 = Place(
            0,
            place_name10,
            place_desc10,
            phone10,
            address10,
            star_point10,
            feature10,
            open_time10,
            close_time10,
            day_open10,
            day_close10,
            image_url10,
            map_url10,
            website10,
            review10,
            category_id10
        )

        val place_name11 = "Parque Bicentenario"
        val place_desc11 = "El parque Bicentenario es un espacio verde de carácter público en la ciudad de Quito D.M., capital de Ecuador"
        val phone11 = "No Phone"
        val address11 = "Antigua terminal aerea, Av. Río Amazonas, Quito 170104"
        val star_point11 = "4.4"
        val feature11 = 1
        val open_time11 = "6:00am"
        val close_time11 = "18:00pm"
        val day_open11 = "L-M-M-J-V-S-D"
        val day_close11 = "No"
        val image_url11 = "https://cdn-3.expansion.mx/dims4/default/27bf323/2147483647/strip/true/crop/659x346+0+58/resize/1200x630!/format/jpg/quality/80/?url=https%3A%2F%2Fcdn-3.expansion.mx%2F52%2F5283c758d79184b10cfaf1ad40232002%2Fparque-bicentenario20180816104604.jpg"
        val map_url11 = "https://www.google.com/maps/dir/-0.1189624,-78.4410889/parque+metropolitano+NORTE/@-0.127415,-78.5012333,13z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x91d59012c10c3417:0x6fa6f445d9a711a3!2m2!1d-78.4879579!2d-0.1419957"
        val website11 = "https://www.quito.gob.ec/"
        val review11 = "Extenso parque con caminos arbolados, instalaciones deportivas y jardines ornamentales en un antiguo aeropuerto"
        val category_id11 = 5
        val place11 = Place(
            0,
            place_name11,
            place_desc11,
            phone11,
            address11,
            star_point11,
            feature11,
            open_time11,
            close_time11,
            day_open11,
            day_close11,
            image_url11,
            map_url11,
            website11,
            review11,
            category_id11
        )

        val place_name12 = "Entrada Parque Metropolitano de Quito o Parque Guanguiltagua"
        val place_desc12 = "Caminatas y paseos en bicicleta por colinas y bosques con vista a la ciudad, además de avistamiento de llamas"
        val phone12 = "(02) 290-7005 ext. 31697"
        val address12 = "Guanguiltagua, Quito 170135"
        val star_point12 = "4.7"
        val feature12 = 0
        val open_time12 = "6:00am"
        val close_time12 = "17:00pm"
        val day_open12 = "L-M-M-J-V-S-D"
        val day_close12 = "No"
        val image_url12 = "https://img.goraymi.com/2018/07/24/878e4100a5ff1cca59f15ee758c5a49f_xl.jpg"
        val map_url12 = "https://www.google.com/maps/dir/-0.1189624,-78.4410889/parque+metropolitano/@-0.1444376,-78.4921796,13z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x91d5907fc3161e29:0x8cd43aee275a9201!2m2!1d-78.472098!2d-0.1800064"
        val website12 = "https://www.quito.gob.ec/"
        val review12 = "Parque Metropolitano Guangüiltagua Quito. Tiene entrada gratuita para los ecuatorianos y visitantes extranjeros,"
        val category_id12 = 5
        val place12 = Place(
            0,
            place_name12,
            place_desc12,
            phone12,
            address12,
            star_point12,
            feature12,
            open_time12,
            close_time12,
            day_open12,
            day_close12,
            image_url12,
            map_url12,
            website12,
            review12,
            category_id12
        )

        val place_name13 = "Comida Típica David"
        val place_desc13 = "Consumo en el lugar · Retiros en la puerta · Entrega sin contacto"
        val phone13 = "(02) 295-5275"
        val address13 = "José Joaquín Olmedo Oe4-49, Quito 170401"
        val star_point13 = "4.8"
        val feature13 = 0
        val open_time13 = "8:30am"
        val close_time13 = "16:00pm"
        val day_open13 = "L-M-M-J-V-S"
        val day_close13 = "Domingo"
        val image_url13 = "https://scontent.fuio1-2.fna.fbcdn.net/v/t39.30808-6/273436257_1859211380947227_6853895515235679143_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=Wz6vX8BZoPYAX-PsxCD&_nc_ht=scontent.fuio1-2.fna&oh=00_AT_mbNLff5r7wvKaWj9vRQHUjRnPTRzwI0CvMICKNacZyA&oe=621FCE5C"
        val map_url13 = "https://www.google.com/maps/place/Comida+T%C3%ADpica+David/@-0.2184661,-78.5129741,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59b58c7392999:0xb9cebebc253f0401!8m2!3d-0.2184912!4d-78.5108016"
        val website13 = "https://www.facebook.com/ComidaTipicaDavidEc/"
        val review13 = "Hablar de tradición es hablar de restaurante David. En La Capital de los ecuatorianos, se conserva una gastronomía muy propia que incluye una gran variedad de platos, unos tan antiguos como la misma ciudad."
        val category_id13 = 1
        val place13 = Place(
            0,
            place_name13,
            place_desc13,
            phone13,
            address13,
            star_point13,
            feature13,
            open_time13,
            close_time13,
            day_open13,
            day_close13,
            image_url13,
            map_url13,
            website13,
            review13,
            category_id13
        )

        val place_name14 = "LA Gran Cocina Tipica"
        val place_desc14 = "Seattle-based coffeehouse chain known for its signature roasts, light bites and WiFi availability."
        val phone14 = "(02) 261-5790"
        val address14 = "MARISCAL SUCRE S10-703 Y, ANTONIO JARAMILLO, Quito"
        val star_point14 = "4.2"
        val feature14 = 0
        val open_time14 = "9:00am"
        val close_time14 = "21:30pm"
        val day_open14 = "L-M-M-J-V-S-D"
        val day_close14 = "No"
        val image_url14 = "https://scontent.fuio1-1.fna.fbcdn.net/v/t1.6435-9/87394746_1845577038908098_2300733982406344704_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=924451&_nc_ohc=AulzGRZ-pogAX-B4Vz4&_nc_ht=scontent.fuio1-1.fna&oh=00_AT8OjhkTuZinBblzXIoQoCoaDncbESnkopQb9WnLxdW2Tw&oe=6241CB82"
        val map_url14 = "https://www.google.com/maps/place/LA+Gran+Cocina+Tipica/@-0.2459423,-78.5362383,17z/data=!3m1!4b1!4m5!3m4!1s0x91d5999fc356981d:0xc6eb8f03b8f506bd!8m2!3d-0.2459423!4d-78.5340496"
        val website14 = "https://www.facebook.com/LaGranCocinaTipica/?ref=bookmarks"
        val review14 = "Muy buena opción para desayunar o almorzar en el Centro Histórico"
        val category_id14 = 1
        val place14 = Place(
            0,
            place_name14,
            place_desc14,
            phone14,
            address14,
            star_point14,
            feature14,
            open_time14,
            close_time14,
            day_open14,
            day_close14,
            image_url14,
            map_url14,
            website14,
            review14,
            category_id14
        )

        val place_name15 = "El Changarro (Comida Tipica y Carnes al Carbón)"
        val place_desc15 = "Consumo en el lugar · Pedidos desde el automóvil · Entrega sin contacto"
        val phone15 = "(02) 283-0939"
        val address15 = "17 de Septiembre, Quito"
        val star_point15 = "4.1"
        val feature15 = 0
        val open_time15 = "15:00pm"
        val close_time15 = "22:00pm"
        val day_open15 = "L-M-M-J-V-S"
        val day_close15 = "Domingo"
        val image_url15 = "https://lh5.googleusercontent.com/p/AF1QipPG-TWT1ffFsMmiMga1AE1zOXMVzCcYIJUI_zpg=w1080-k-no"
        val map_url15 = "https://www.google.com/maps/place/El+Changarro+(Comida+Tipica+y+Carnes+al+Carb%C3%B3n)/@-0.1340398,-78.446039,17z/data=!3m1!4b1!4m5!3m4!1s0x91d58fc5b4c2cf31:0x1366fa1482d2c250!8m2!3d-0.1340398!4d-78.4438503"
        val website15 = "No disponibñe"
        val review15 = "Muy deliciosa la comida."
        val category_id15 = 1
        val place15 = Place(
            0,
            place_name15,
            place_desc15,
            phone15,
            address15,
            star_point15,
            feature15,
            open_time15,
            close_time15,
            day_open15,
            day_close15,
            image_url15,
            map_url15,
            website15,
            review15,
            category_id15
        )

        val place_name16 = "Miskay"
        val place_desc16 = "Comida ecuatoriana con producto nacional. Cocina típica y de autor. Realzando la cultura y tradiciones de la gastronomía ecuatoriana."
        val phone16 = "098 794 6373"
        val address16 = "Joaquín Pinto E6-43, Quito 170524"
        val star_point16 = "4.5"
        val feature16 = 0
        val open_time16 = "12:00pm"
        val close_time16 = "21:00pm"
        val day_open16 = "L-M-M-J-V-S-D"
        val day_close16 = "No"
        val image_url16 = "https://scontent.fuio1-2.fna.fbcdn.net/v/t1.18169-9/17760075_381573352229118_4499719405633584195_n.png?_nc_cat=100&ccb=1-5&_nc_sid=e3f864&_nc_ohc=P_gmiJkcA3kAX--N17d&_nc_ht=scontent.fuio1-2.fna&oh=00_AT_M2c3yH8cFCIcNd9gKvkajyuDgElzyT-YrLi4DeTzfaw&oe=6240E6E1"
        val map_url16 = "https://www.google.com/maps/place/Miskay/@-0.2030392,-78.493693,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59a136f67b1c5:0x841bb6a04c974ebd!8m2!3d-0.2030077!4d-78.491448"
        val website16 = "https://miskay.ec/en/"
        val review16 = "Miskay is gastronomic culture, the culture recovered through food, and in general through everything that the establishment includes, ingredients, atmosphere, decoration, murals, makes being in Miskay mean a complete experience."
        val category_id16 = 1
        val place16 = Place(
            0,
            place_name16,
            place_desc16,
            phone16,
            address16,
            star_point16,
            feature16,
            open_time16,
            close_time16,
            day_open16,
            day_close16,
            image_url16,
            map_url16,
            website16,
            review16,
            category_id16
        )

        val place_name17 = "Parque Guápulo"
        val place_desc17 = "Área verde amplia con 2 lagunas, pistas deportivas, un parque infantil, palmerales y eucaliptos."
        val phone17 = "(02) 323-8834"
        val address17 = "Av. de los Conquistadores, Quito 170157"
        val star_point17 = "4.7"
        val feature17 = 0
        val open_time17 = "6:00am"
        val close_time17 = "18:00pm"
        val day_open17 = "L-M-M-J-V-S-D"
        val day_close17 = "No"
        val image_url17 = "https://chiquitosybebes.com/wp-content/uploads/2015/12/%C2%BF-CONOCES-EL-PARQUE-DE.jpg"
        val map_url17 = "https://www.google.com/maps/place/Parque+Gu%C3%A1pulo/@-0.1968675,-78.4748765,17z/data=!3m1!4b1!4m5!3m4!1s0x91d5909e7bb84a19:0xcd779f052c2b7d74!8m2!3d-0.1968675!4d-78.4726878"
        val website17 = "https://www.quito.gob.ec/"
        val review17 = "¿En busca de lugares tranquilos en Quito? Este parque, que se encuentra ubicado a aproximadamente 30 minutos del centro, es excelente para un día de picnic con tu pareja, dar un romántico paseo por la laguna o descansar bajo los árboles. Si tienes más tiempo libre, cerca a Guápulo se encuentra La Floresta, uno de los hermosos barrios de Quito por visitar."
        val category_id17 = 2
        val place17 = Place(
            0,
            place_name17,
            place_desc17,
            phone17,
            address17,
            star_point17,
            feature17,
            open_time17,
            close_time17,
            day_open17,
            day_close17,
            image_url17,
            map_url17,
            website17,
            review17,
            category_id17
        )

        val place_name18 = "Parque Rumipamba"
        val place_desc18 = "Muros de piedra, cerámica y ruinas de tumbas de antiguos pueblos que datan del 1500 a. C."
        val phone18 = "(02) 224-2313"
        val address18 = "Nuño de Valderrama s/n, Quito 170147"
        val star_point18 = "4.5"
        val feature18 = 0
        val open_time18 = "9:00am"
        val close_time18 = "16:00am"
        val day_open18 = "L-M-M-J-V-S-D"
        val day_close18 = "No"
        val image_url18 = "https://pbs.twimg.com/media/ElnbDxKWoAAxFjJ.jpg"
        val map_url18 = "https://www.google.com/maps/place/Parque+Arqueol%C3%B3gico+Rumipamba/@-0.1801565,-78.5026513,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59af47cc5d323:0x41c76618d48baeb1!8m2!3d-0.1801565!4d-78.5004626"
        val website18 = "https://www.turismo.gob.ec/museo-arqueologico-rumipamba-un-espacio-ancestral-abierto-al-publico/"
        val review18 = "Un espacio ancestral que data del año 1500 a.C. al 1500 d.C. se muestra en medio del Parque Ecológico Rumipamba. Este complejo se ubica al oeste de la capital del Ecuador, Quito, exactamente en la avenida Occidental y Mariana de Jesús."
        val category_id18 = 2
        val place18 = Place(
            0,
            place_name18,
            place_desc18,
            phone18,
            address18,
            star_point18,
            feature18,
            open_time18,
            close_time18,
            day_open18,
            day_close18,
            image_url18,
            map_url18,
            website18,
            review18,
            category_id18
        )

        val place_name19 = "Parque La Alameda"
        val place_desc19 = "El parque La Alameda es un espacio verde de carácter público en la ciudad de Quito, capital de Ecuador. Está ubicado en el centro de la urbe, perteneciente a la parroquia Centro Histórico, dentro de un triángulo comprendido por la avenida Gran Colombia, la avenida 10 de Agosto y la calle Luis Sodiro"
        val phone19 = "No Phone"
        val address19 = "Av. Gran Colombia 242, Quito 170136"
        val star_point19 = "4.2"
        val feature19 = 0
        val open_time19 = "24hrs"
        val close_time19 = "No"
        val day_open19 = "L-M-M-J-V-S-D"
        val day_close19 = "No"
        val image_url19 = "https://i.ytimg.com/vi/XZ4v7XFrO0k/maxresdefault.jpg"
        val map_url19 = "https://www.google.com/maps/place/Parque+La+Alameda/@-0.2146667,-78.5046124,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59a23e66e52d7:0x59c9463b41b2a3e2!8m2!3d-0.2146667!4d-78.5024237"
        val website19 = "https://www.quito.gob.ec/"
        val review19 = "Parque urbano con observatorio astronómico, una estatua de Simón Bolívar y un lago con barcos para rentar."
        val category_id19 = 2
        val place19 = Place(
            0,
            place_name19,
            place_desc19,
            phone19,
            address19,
            star_point19,
            feature19,
            open_time19,
            close_time19,
            day_open19,
            day_close19,
            image_url19,
            map_url19,
            website19,
            review19,
            category_id19
        )

        val place_name20 = "Parque del Arbolito"
        val place_desc20 = "Fue inaugurado en 1932 y demolido en 1966, tras caer paulatinamente en el olvido a raíz de la inauguración del estadio Olímpico Atahualpa, en 1951. "
        val phone20 = "No Phone"
        val address20 = "Av. 6 de Diciembre y 12 de Octubre, Quito, Ecuador"
        val star_point20 = "5.0"
        val feature20 = 0
        val open_time20 = "No Disponible"
        val close_time20 = "No Disponible"
        val day_open20 = "No Disponible"
        val day_close20 = "No Disponible"
        val image_url20 = "https://upload.wikimedia.org/wikipedia/commons/9/9d/Parque_El_Arbolito_%28panor%C3%A1mica%29.jpg"
        val map_url20 = "https://www.google.com/maps/place/Estadio+El+Arbolito/@-0.2111913,-78.4988566,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59b55a305ec53:0xa314516415fb58cb!8m2!3d-0.2111913!4d-78.4966679"
        val website20 = "https://www.quito.gob.ec/"
        val review20 = "El parque El Arbolito es uno de los íconos de la concentración popular y política, desde el gobierno de Sixto Durán Ballén (1992-1996).."
        val category_id20 = 2
        val place20 = Place(
            0,
            place_name20,
            place_desc20,
            phone20,
            address20,
            star_point20,
            feature20,
            open_time20,
            close_time20,
            day_open20,
            day_close20,
            image_url20,
            map_url20,
            website20,
            review20,
            category_id20
        )

        val place_name21 = "Basílica del Voto Nacional"
        val place_desc21 = "La Basílica del Voto Nacional, también llamada de la Consagración de Jesús o Basílica de San Juan, es un edificio religioso de estilo neogótico del centro histórico de la ciudad de Quito D.M"
        val phone21 = "(02) 228-9428"
        val address21 = "Venezuela y Francisco de Caldas,Quito 170130"
        val star_point21 = "4.8"
        val feature21 = 0
        val open_time21 = "9:00am"
        val close_time21 = "17:30pm"
        val day_open21 = "L-M-M-J-V-S-D"
        val day_close21 = "No"
        val image_url21 = "http://www.efetur.com/files/2020/05/Bas%C3%ADlica-del-Voto-Nacional.jpg"
        val map_url21 = "https://www.google.com/maps/place/Bas%C3%ADlica+del+Voto+Nacional/@-0.2148472,-78.5096142,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59a25c31db3b5:0x6c011283454d8bce!8m2!3d-0.2151063!4d-78.5076132"
        val website21 = "https://www.quito.gob.ec/"
        val review21 = "La Basílica del Voto Nacional es la obra más importante de la arquitectura neogótica ecuatoriana y una de las más representativas del continente americano, siendo a su vez la más grande en tierras del nuevo mundo. Por su estructura y estilo, es comparada con dos de las grandes catedrales de todo el mundo: la Catedral de San Patricio (Nueva York) y la Catedral de Notre Dame (París)."
        val category_id21 = 5
        val place21 = Place(
            0,
            place_name21,
            place_desc21,
            phone21,
            address21,
            star_point21,
            feature21,
            open_time21,
            close_time21,
            day_open21,
            day_close21,
            image_url21,
            map_url21,
            website21,
            review21,
            category_id21
        )

        val place_name22 = "Plaza Foch"
        val place_desc22 = "El corazón de La Mariscal se encuentra en la Plaza Quinde –conocida como \"Plaza Foch\" por los locales, en el cruce de la calles Mariscal Foch y Reina Victoria. Se caracteriza por tener varios centros de diversión como sonr Bares, discotecas,cafeterías, restaurantes que te envuelve en un ambiente confortable y alegre."
        val phone22 = "No disponible"
        val address22 = "José Calama E7-35 y Reina Victoria, . Quito, Ecuador."
        val star_point22 = "4.1"
        val feature22 = 0
        val open_time22 = "24hrs"
        val close_time22 = "No"
        val day_open22 = "L-M-M-J-V-S-D"
        val day_close22 = "No"
        val image_url22 = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Plazafoch.jpg/640px-Plazafoch.jpg"
        val map_url22 = "https://www.google.com/maps/place/Mariscal+Foch,+Quito/@-0.2033062,-78.4929643,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59a135ab01af3:0x2443f8cb1d705eeb!8m2!3d-0.2033062!4d-78.4907756"
        val website22 = "https://www.goraymi.com/es-ec/pichincha/quito/parques-plazas/plaza-foch-ac9bb2de3"
        val review22 = "Foch Quito te proporcina los fines de semana música en vivo, este es el principal punto de encuentro de diversión en la zona. Los sábados, la feria Asara, de la Asociación de Artes Aplicadas, es donde decenas de artesanos y artistas exhiben trabajos en madera, tagua, vidrio, tela, cuero o papel reciclado. Además, se ofrecen productos orgánicos, como mermeladas, chocolate y cosméticos hechos a base de miel."
        val category_id22 = 4
        val place22 = Place(
            0,
            place_name22,
            place_desc22,
            phone22,
            address22,
            star_point22,
            feature22,
            open_time22,
            close_time22,
            day_open22,
            day_close22,
            image_url22,
            map_url22,
            website22,
            review22,
            category_id22
        )

        val place_name23 = "Iglesia de San Francisco"
        val place_desc23 = "En todo el centro histórico está uno de los lugares para visitar en Quito más populares. El edificio se sitúa en la intersección de las calles Benalcázar, Bolívar, Sucre y Cuenca."
        val phone23 = "(02) 295-9911"
        val address23 = "Cuenca 477, Quito 170401"
        val star_point23 = "4.8"
        val feature23 = 0
        val open_time23 = "7:00am y 15:00pm"
        val close_time23 = "12:00pm y 17:30pm"
        val day_open23 = "L-M-M-J-V-S-D"
        val day_close23 = "No"
        val image_url23 = "https://www.arquitecturapanamericana.com/wp-content/uploads/2016/05/San-Francisco-Una-historia-para-el-futuro.jpg"
        val map_url23 = "https://www.google.com/maps/place/Iglesia+Cat%C3%B3lica+San+Francisco+%7C+Quito/@-0.2204844,-78.5173704,17z/data=!3m1!4b1!4m5!3m4!1s0x91d59980ac2e7a71:0xd8e53217c487e79f!8m2!3d-0.2204844!4d-78.5151817"
        val website23 = "https://www.quito.gob.ec/"
        val review23 = "Hay varias razones que hacen a la edificación uno de los atractivos turísticos de Quito: en el altar mayor está la virgen realizada por Bernardo de Legalda; dentro del complejo arquitectónico hay más de 3.500 obras de arte colonial; además, el recinto tiene una biblioteca franciscana, la cual fue descrita en el siglo XVII como la mejor del Virreinato del Perú"
        val category_id23 = 4
        val place23 = Place(
            0,
            place_name23,
            place_desc23,
            phone23,
            address23,
            star_point23,
            feature23,
            open_time23,
            close_time23,
            day_open23,
            day_close23,
            image_url23,
            map_url23,
            website23,
            review23,
            category_id23
        )

        val place_name24 = "Universidad Central del Ecuador"
        val place_desc24 = "La Universidad Central del Ecuador, es la universidad más antigua y la segunda más grande por número de estudiantes de la República del Ecuador."
        val phone24 = "(02) 252-8810"
        val address24 = "Av. Universitaria, Quito 170129"
        val star_point24 = "5.0"
        val feature24 = 0
        val open_time24 = "7:30am"
        val close_time24 = "18:00pm"
        val day_open24 = "L-V"
        val day_close24 = "S-D"
        val image_url24 = "https://www.pichinchacomunicaciones.com.ec/wp-content/uploads/2020/09/Universidad-Central.jpg"
        val map_url24 = "https://www.google.com/maps/place/Universidad+Central+del+Ecuador/@-0.2006288,-78.5045776,17z/data=!3m1!4b1!4m9!1m2!2m1!1suce!3m5!1s0x91d59a8c54484dc1:0xd181ba6389c436e2!8m2!3d-0.2006288!4d-78.5023889!15sCgN1Y2WSARFwdWJsaWNfdW5pdmVyc2l0eQ"
        val website24 = "https://www.uce.edu.ec/"
        val review24 = "La Universidad Central del Ecuador, remonta sus orígenes a la Universidad Central de Quito. La cual se originó de la unión de las Universidades: San Gregorio Magno fundada en 1620 por los Jesuitas y la Santo Tomás de Aquino, fundada en 1688 por los Dominicos."
        val category_id24 = 4
        val place24 = Place(
            0,
            place_name24,
            place_desc24,
            phone24,
            address24,
            star_point24,
            feature24,
            open_time24,
            close_time24,
            day_open24,
            day_close24,
            image_url24,
            map_url24,
            website24,
            review24,
            category_id24
        )

        val place_name25 = "Los Pollos de la Tri"
        val place_desc25 = "Juntos viviremos la experiencia más sabrosa y deportiva, eres nuestro invitado estrella.\n" +
                "Ponte pilas con nuestro menú, no te lo puedes perder"
        val phone25 = "023650788"
        val address25= "Luis Francisco López S/N, Quito 170708"
        val star_point25 = "4.1"
        val feature25 = 0
        val open_time25 = "11:00am"
        val close_time25 = "20:00pm"
        val day_open25 = "L-M-M-J-V-S"
        val day_close25 = "Domingo"
        val image_url25 = "https://scontent.fuio1-2.fna.fbcdn.net/v/t1.6435-9/135366936_1708189999342428_5629713145482710647_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=-CQCdyHFZyoAX_jzUn1&_nc_ht=scontent.fuio1-2.fna&oh=00_AT-ECG-tMyAEqLmME3oRfpYgYffLAg3zIUhwNKHAdpfBcA&oe=624210F1"
        val map_url25 = "https://www.google.com/maps/place/Los+Pollos+de+la+Tri/@-0.2764233,-78.5549511,17z/data=!3m1!4b1!4m5!3m4!1s0x91d598b8428e5673:0xf0f60029f83be717!8m2!3d-0.2764188!4d-78.5527618"
        val website25 = "https://www.lospollosdelatri.com.ec/menu-sur-de-quito/#"
        val review25 = "Es el primer asadero deportivo en el Ecuador en donde nuestros clientes disfrutan del fútbol y se deleitan de nuestros combos con las mejores promociones"
        val category_id25 = 1
        val place25 = Place(
            0,
            place_name25,
            place_desc25,
            phone25,
            address25,
            star_point25,
            feature25,
            open_time25,
            close_time25,
            day_open25,
            day_close25,
            image_url25,
            map_url25,
            website25,
            review25,
            category_id25
        )

        mPlaceViewModel.addPlace(place)
        mPlaceViewModel.addPlace(place1)
        mPlaceViewModel.addPlace(place3)
        mPlaceViewModel.addPlace(place4)
        mPlaceViewModel.addPlace(place5)
        mPlaceViewModel.addPlace(place6)
        mPlaceViewModel.addPlace(place7)
        mPlaceViewModel.addPlace(place9)
        mPlaceViewModel.addPlace(place10)
        mPlaceViewModel.addPlace(place11)
        mPlaceViewModel.addPlace(place12)
        mPlaceViewModel.addPlace(place13)
        mPlaceViewModel.addPlace(place14)
        mPlaceViewModel.addPlace(place15)
        mPlaceViewModel.addPlace(place16)
        mPlaceViewModel.addPlace(place17)
        mPlaceViewModel.addPlace(place18)
        mPlaceViewModel.addPlace(place19)
        mPlaceViewModel.addPlace(place20)
        mPlaceViewModel.addPlace(place21)
        mPlaceViewModel.addPlace(place22)
        mPlaceViewModel.addPlace(place23)
        mPlaceViewModel.addPlace(place24)
        mPlaceViewModel.addPlace(place25)

        Toast.makeText(this, "Create Place Successful !!!!", Toast.LENGTH_SHORT).show()
    }

}