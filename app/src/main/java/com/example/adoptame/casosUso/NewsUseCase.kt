package com.example.adoptame.casosUso

import com.example.adoptame.entidades.News

class NewsUseCase {

    private val newsList = listOf<News>(
        News(
            "Cumbre del Panecillo, Gral Melchor Aymerich, Quito EC170150, Ecuador",
            "VIRGEN DE EL PANECILLO",
            "El Panecillo es una elevación natural de 3.000 metros sobre el nivel del mar, fue bautizada con este nombre por su parecido con un pequeño pan; está enclavada en el corazón mismo de la ciudad de Quito. Es uno de los sitios más visitados de la ciudad. Por su ubicación se ha convertido en el más importante mirador natural de la ciudad, desde el que se puede apreciar la disposición urbana de la capital, desde su centro histórico y hacia los extremos norte y sur.\n" +
                    "\n" +
                    "El lugar recibió su nombre de los conquistadores españoles, pues antes era llamado por los aborígenes como “Shungoloma” que en quichua significa “loma del corazón”. En la época pre incaica, en este sitio existió un templo de adoración al sol, llamado “Yavirac”, el cual fue destruido por Rumiñahui mientras resistía con sus tropas al avance español.",
            "https://imagenes.laestrella.com.pa/files/image_990_491/uploads/2019/09/16/5d7f49e0deb2c.jpg"
        ),
        News(
            "Fulgencio Araujo, y, Quito 170527",
            "Teleférico de Quito",
            "El teleférico es uno de lugares turísticos de Quito que no debes dejar de visitar. Es uno de los más altos de Sudamérica: su recorrido de 18 minutos aproximadamente comienza a 3.000 metros y culmina a los 4.100. Desde esas alturas tienes impresionantes vistas panorámicas de la ciudad y sus alrededores.\n" +
                    "En los alrededores del teleférico hay uno de los sitios para acampar en Quito, además se pueden hacer cabalgatas o vuelos en parapente. Todos los servicios se contratan en la base del teleférico.\n",
            "https://teleferico.com.ec/wp-content/uploads/2019/04/imagen_inicio3.jpg"
        ),
        News(
            "Av. Manuel Córdova Galarza SN, Quito",
            "Mitad del Mundo",
            "El país lleva su nombre por la curiosidad de estar atravesado de este a oeste por la línea ecuatorial. Para celebrar esa singularidad se edificó uno de 10 lugares turísticos del Ecuador más visitados. En el sitio hay un monumento y otras construcciones. Con respecto al primero hay dos datos curiosos: primero, que el actual es una réplica del original que medía 10 metros y que ahora se emplaza en la ciudad Calacali; segundo, que en realidad la línea equinoccial se ubica a 240 metros hacia el sur de donde se encuentra el monolito.\n" +
                    "En las cercanías hay varios atractivos como la Plaza Cultural con banquitos tipo anfiteatros en donde se realizan conciertos los fines de semana. Pero si buscas lugares románticos en Quito, la ciudad tiene una capilla donde se efectúan enlaces matrimoniales. Hay ofertas gastronómicas como la Plaza del Cacao. Ahí se puede conocer cómo es la producción, la preparación y el consumo del fruto.\n",
            "https://cloudfront-us-east-1.images.arcpublishing.com/eluniverso/IJL6QOFW7ZCWBHWUAE37RUNKAI.jpg"
        ),
        News(
            "García Moreno, Quito 170401",
            "Palacio de Carondelet",
            "En todo el centro de la ciudad se halla uno de los lugares históricos de Quito más conocidos: el edificio que funciona como sede del Gobierno del Ecuador. Desde 2007 se abrió para recibir visitas guiadas y dar a conocer sus diferentes áreas. Entre ellas puedes recorrer el Salón Amarillo, el Salón de Presidentes, el Salón de Banquetes, el Oratorio y el Salón de Gabinete.\n" +
                    "En la edificación hay exposiciones permanentes con los obsequios, tanto nacionales como internacionales, entregados al primer mandatario. Destacan las centenarias sillas que fueron talladas por el artista italiano Juan Bautista Minghetti, el mismo que realizó los bocetos del monumento a la Independencia, situado en el corazón de la Plaza Grande.\n",
            "https://live.staticflickr.com/3062/2873544803_acddc90af8_b.jpg"
        ),
        News(
            "Av. 6 de Diciembre 345, Quito 170136",
            "Casa de la Cultura Ecuatoriana",
            "Uno de los intelectuales más destacados de Ecuador en el siglo XX fue Benjamín Carrión Mora. Este personaje promovió el desarrollo de la cultura y la libertad de pensamiento en Ecuador, y creó la Casa de la Cultura Ecuatoriana (CCE) en agosto de 1944.\n" +
                    "\n" +
                    "La cultura de la ciudad, los museos, las publicaciones están presentes en todo el país en 24 sucursales de la Casa de la Cultura, pero la sede nacional está en Quito y puedes incluirla en tu itinerario para una visita bastante cultural.",
            "https://www.ecuadorhop.com/wp-content/uploads/2020/01/casa-de-la-cultura-de-quito-lugares-turisticos-de-quito-web.jpg"
        )
    )


    fun getAllNews(): List<News> {
        return newsList
    }

}