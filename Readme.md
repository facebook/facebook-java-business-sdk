LÉAME.md
SDK empresarial de Facebook para Java
NOTAS DE CAMBIOS IMPORTANTES (v3.0.0) : La nueva versión de Java SDK (v3.0.0) incluye los siguientes cambios importantes:

Actualización de la versión de la API: la nueva versión del SDK llama a los puntos finales de la API Graph de Facebook relacionados con los productos Pages, Instagram, Business Manager y Marketing. Las clases ahora usan nuevos campos/parámetros/puntos finales. Consulte el Registro de cambios de Graph API para obtener más información.
Introducción
El SDK de Facebook Business es una ventanilla única para ayudar a nuestros socios a brindar un mejor servicio a sus negocios. Los socios utilizan varias API de Facebook para satisfacer las necesidades de sus clientes. Adoptar todas estas API y mantenerlas actualizadas en las diversas plataformas puede llevar mucho tiempo y, en última instancia, ser prohibitivo. Por esta razón, Facebook ha desarrollado Business SDK que agrupa muchas de sus API en un solo SDK para facilitar la implementación y el mantenimiento. Business SDK es una versión mejorada de Marketing API SDK que incluye Marketing API, así como muchas API de Facebook de diferentes plataformas, como Pages, Business Manager, Instagram, etc.

facebook-java-business-sdkes una biblioteca Java que proporciona una interfaz entre su aplicación Java y la API Graph de Facebook . Este tutorial cubre los conceptos básicos, incluidos ejemplos, necesarios para usar el SDK.

Inicio rápido
Guía de introducción al SDK empresarial

requisitos previos
registrar una aplicación
Para comenzar con el SDK, debe tener una aplicación registrada en desarrolladores.facebook.com .

Para administrar la API de marketing, visite su Panel de aplicaciones y agregue el producto API de marketing a su aplicación.

IMPORTANTE : Por motivos de seguridad, se recomienda que active 'Prueba de secreto de la aplicación para llamadas a la API del servidor' en la página Configuración->Avanzado de su aplicación.

Obtenga un token de acceso
Cuando alguien se conecta con una aplicación mediante el inicio de sesión de Facebook y aprueba la solicitud de permisos, la aplicación obtiene un token de acceso que brinda acceso temporal y seguro a las API de Facebook.

Un token de acceso es una cadena opaca que identifica a un usuario, una aplicación o una página.

Por ejemplo, para acceder a la API de marketing, debe generar un token de acceso de usuario para su aplicación y solicitar el ads_managementpermiso; para acceder a la API de páginas, debe generar un token de acceso a la página para su aplicación y solicitar el manage_pagepermiso.

Consulte nuestra Guía de tokens de acceso para obtener más información.

Por ahora, podemos usar Graph Explorer para obtener un token de acceso.

Paquete de instalación
Para comenzar a utilizar el SDK de Java, siga las instrucciones de la sección Introducción .

Si desea utilizar un archivo .jar precompilado, visite https://repo1.maven.org/maven2/com/facebook/business/sdk/facebook-java-business-sdk/ para descargar una versión específica. Si descarga el que no tiene dependencias, deberá descargar todos los archivos .jar dependientes y agregarlos a su ruta al compilar y ejecutar. Utilice el archivo .pom en el directorio de versiones para decidir las dependencias.

Ejecutar código de muestra
Aquí está el código mínimo necesario para crear una campaña en su cuenta publicitaria. Si su aplicación y los entornos de compilación están configurados correctamente, este código debería compilarse y ejecutarse sin errores. Puedes verificar la campaña creada en Ads Manager .

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdAccount.EnumCampaignStatus;
import com.facebook.ads.sdk.AdAccount.EnumCampaignObjective;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.APIException;

public class QuickStartExample {

  public static final String ACCESS_TOKEN = "[Your access token]";
  public static final Long ACCOUNT_ID = [Your account ID];
  public static final String APP_SECRET = "[Your app secret]";

  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
  public static void main(String[] args) {
    try {
      AdAccount account = new AdAccount(ACCOUNT_ID, context);
      Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .execute();
      System.out.println(campaign.fetch());
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
Más ejemplos se pueden encontrar en la /examplescarpeta.

Descripción del SDK empresarial
Consulte la documentación del Business SDK para obtener más información sobre la implementación y los escenarios comunes. El Business SDK es coherente con los puntos finales v3.0 relacionados con las páginas, el administrador comercial, Instagram y los productos de marketing. Consulte las API dentro del Business SDK para obtener la lista de las API que se encuentran dentro del Business SDK.

obtener un objeto
Siempre debe crear un APIContext antes de realizar llamadas a la API. APIContext incluye su token de acceso y el secreto de la aplicación:

APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
Para obtener un objeto de campaña:

Campaign campaign = new Campaign(CAMPAIGN_ID, context); // this only creates a new empty object
campaign = campaign.get().requestAllFields().execute();
// 1. get() is the API call name to get the object;
// 2. requestAllFields() means you want all the fields. If you only want certain fields, then you can call requestXXXFields() instead, and sever response will only contain specified fields.
// 3. ***IMPORTANT*** any API calls should end with execute(), otherwise it will not be executed.
O bien, puede usar un atajo equivalente:

Campaign campaign = Campaign.fetchById(CAMPAIGN_ID, context);
Después de buscar el objeto, puede leer los datos del interior:

String id = campaign.getFieldId();
String name = campaign.getFieldName();
// Note that the methods to read field data are getFieldXXX(). This is to distinguish method names of field data from method names of API GET calls.
Actualizar y Eliminar
Actualizar :

campaign.update()
        .setName("Updated Java SDK Test Campaign") // set parameter for the API call
        .execute();
Eliminar :

campaign.delete().execute();
Edge Read and Write (Crear objeto)
Edge es un concepto relacional en Graph API.

Por ejemplo, si desea conocer todas las campañas en una cuenta publicitaria, llame a GET en el campaignsborde desde el objeto de la cuenta publicitaria.

O, si desea crear una nueva campaña en esta cuenta, llame a POST (crear) en el campaignsborde de la cuenta publicitaria.

Leer:
AdAccount account = new AdAccount(ACCOUNT_ID, context);
APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
for(Campaign campaign : campaigns) {
	System.out.println(campaign.getFieldName());
}
** Importante **: Manejo de la paginación: la mayoría de las API perimetrales tienen una paginación predeterminada, que devuelve una cantidad limitada de objetos (~30 objetos) en lugar de la lista completa. Si desea cargar más, debe realizar una llamada a la API por separado. En nuestro SDK, puede llamar a nextPage():

campaigns = campaigns.nextPage();
O habilite el iterador de paginación automática con:
campaigns = campaigns.withAutoPaginationIterator(true);
En este caso,campañas.iterator() devolverá un iterador que puede recuperar la página siguiente automáticamente.

// Enhanced for loop
for(Campaign campaign : campaigns) {
	System.out.println(campaign.getFieldName());
}

// Foreach with lambda is also supported
campaigns.forEach(campaign -> System.out.println(campaign.getFieldName()));

// Note: APIException will be wrapped in a Runtime exception
Para recuperar todas las campañas en su cuenta.

Con el iterador de paginación automática, la página siguiente se buscará automáticamente en bucle for mejorado y bucle foreach. En este escenario, campaign.size(), campaign.get(i)ya no es confiable y no debe usarse

Escribir (crear objeto):
La mayoría de los objetos están bajo la cuenta de anuncios. Por lo tanto, siempre querrá probar account.createXXX() para crear un objeto.

AdAccount account = new AdAccount(ACCOUNT_ID, context);
Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .execute();
// The create call only returns id of the new object.
// So you want to fetch() to get all the data of the object.
// fetch() is just another shortcut for
// campaign = campaign.get().requestAllFields().execute();
campaign.fetch();
Por lotes
Cada ejecución () es una solicitud HTTP, que realiza un viaje de ida y vuelta a la red. La API de Facebook admite el modo por lotes , lo que le permite realizar varias llamadas a la API en una sola solicitud HTTP.

En este SDK, simplemente puede reemplazar execute() con addToBatch() para preparar una llamada a la API por lotes. Cuando esté listo, llame a batch.execute().

Ejemplo:

      BatchRequest batch = new BatchRequest(context);
      account.createCampaign()
        .setName("Java SDK Batch Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .addToBatch(batch, "campaignRequest");
      account.createAdSet()
        .setName("Java SDK Batch Test AdSet")
        .setCampaignId("{result=campaignRequest:$.id}")
        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
        .setDailyBudget(1000L)
        .setBidAmount(100L)
        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
        .setTargeting(targeting)
        .addToBatch(batch, "adsetRequest");
      account.createAdImage()
        .addUploadFile("file", imageFile)
        .addToBatch(batch, "imageRequest");
      account.createAdCreative()
        .setTitle("Java SDK Batch Test Creative")
        .setBody("Java SDK Batch Test Creative")
        .setImageHash("{result=imageRequest:$.images.*.hash}")
        .setLinkUrl("www.facebook.com")
        .setObjectUrl("www.facebook.com")
        .addToBatch(batch, "creativeRequest");
      account.createAd()
        .setName("Java SDK Batch Test ad")
        .setAdsetId("{result=adsetRequest:$.id}")
        .setCreative("{creative_id:{result=creativeRequest:$.id}}")
        .setStatus("PAUSED")
        .setBidAmount(100L)
        .addToBatch(batch);
      List<APIResponse> responses = batch.execute();
      // responses contains the result of each API call in order. However, if the API calls have dependency, then some result could be null.
Manejo de errores
Actualmente todos los errores están envueltos en APIExceptiony sus subclases.

MalformedResponseExceptiones causado por el análisis incorrecto de una respuesta del servidor (probablemente un error en el SDK).

FailedRequestExceptiones causado por un error del cliente o una falla del servidor. Ver detalles en la siguiente sección.

Tenemos un plan para mejorar esto agregando más detalles y brindando una función conveniente para obtener el código de error.

Personalización y depuración
Habilitar depuración
Puede habilitar la salida de depuración configurando APIContext en modo de depuración:

public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true).setLogger(System.out);
Esto imprimirá las solicitudes y respuestas de la red. De forma predeterminada, se imprime en STDOUT, pero puede personalizarlo llamando a .setLogger(PrintSteam)

Personalizar red
En v0.2.0, agregamos APIRequest.changeRequestExecutor(IRequestExecutor), que se puede usar para configurar su propio ejecutor de solicitudes de red. Esto hace posible agregar configuraciones de proxy, reintentos automáticos o una mejor gestión del tráfico de red. ver /example/NetworkCustomizationExample.java_

Actualmente, este es un método estático porque es probable que sea una configuración global. Si cree que se necesita personalización a nivel de objeto, agregaremos esa funcionalidad.

El ejecutor necesita implementar la IRequestExecutorinterfaz:

    public static interface IRequestExecutor {
        public String execute(String method, String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
        public String sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
        public String sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
        public String sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    }
DefaultRequestExecutorse utiliza de forma predeterminada y también es un buen punto de partida para la personalización.

Parámetros/campos de solicitud faltantes o incorrectos
Se recomienda utilizar setXXX() o requestXXXField() para construir una APIRequest adecuada, lo que evita errores ortográficos en los nombres de parámetros/campos. Sin embargo, si cree que faltan algunos parámetros/campos necesarios en estos métodos, puede llamar a:

    APIRequest.setParam(param, value)
    APIRequest.setParam.requestField(field, true)
Esto también funciona si cree que el tipo de parámetro no es correcto en SDK.

En este caso, ayúdenos a mejorar archivando problemas.

Campos faltantes en la definición de clase
Si cree que ciertos campos se devuelven desde el servidor, pero faltan en la definición de clase, aún puede acceder a esos campos al obtenerlos de la respuesta sin formato:

campaign.getRawResponseAsJsonObject().get("field").getAsString();
Esta situación puede ocurrir ocasionalmente si se agregan nuevos campos a la respuesta del servidor mientras el SDK no está actualizado. Actualizaremos el SDK periódicamente para incluir nuevos campos.

Solicitud de API ad-hoc
La mayor parte de la API de marketing se puede encontrar en las clases SDK. Si no encuentra el que desea acceder, es posible construir un Ad-hoc APIRequest:

    APIRequest<AdAccount> request = new APIRequest<AdAccount>(context, "me", "/adaccounts", "GET", AdAccount.getParser());
    APINodeList<AdAccount> accounts = (APINodeList<AdAccount>)(request.execute());
Al construir APIRequest, debe proporcionar

APIContext, que tiene el token de acceso,
El ID del nodo, que normalmente es un número largo, pero también puede ser un alias, como "yo",
El nombre del borde, que debe comenzar con "/"; si es para una API de nodo, utilice "/"
El método HTTP, GET/POST/DELETE
El analizador para el tipo de respuesta esperado. Puede usar nulo si no está en el SDK, que devolverá APINodeList cuando se ejecute.
Solución de problemas de FailedRequestException
Hay muchas causas posibles para una solicitud fallida:

Se proporcionan parámetros incorrectos en la solicitud de la API (consulte los documentos de la API de gráficos )
Problema de permiso (verifique su token de acceso o el secreto de la aplicación)
Error SDK (informe en Github)
Problema de red temporal (verifique su red y vuelva a intentarlo)
Problema temporal del servidor (reintentar o informar sobre los errores de la plataforma de Facebook si ocurre con demasiada frecuencia)
Error del servidor (informe sobre errores de la plataforma de Facebook )
Como primer paso para solucionar problemas, habilite la depuración en APIContext.

Aquí hay algunos consejos sobre la resolución de problemas:

Si se debe a parámetros incorrectos, verá descripciones de errores en el mensaje de excepción.
Si se debe a un problema de permiso, verá un mensaje de error como "permiso denegado" o "ruta desconocida"
Si en el seguimiento de la pila ve que la solicitud fallida se debe a excepciones como NullPointerException o MalformedResponseException, es probable que se trate de un error del SDK (o de su propio error, según el seguimiento de la pila).
Si ve en el mensaje de depuración que los parámetros enviados al servidor no coinciden con lo que especificó, es posible que no haya especificado el parámetro correctamente o que el SDK no haya ensamblado la solicitud correctamente.
Para un problema temporal del servidor, normalmente el reintento debería funcionar después de unos segundos.
Si el servidor responde persistentemente con "Error desconocido", entonces es potencialmente un error del servidor.
SDK Codegen
Nuestro SDK se genera automáticamente a partir de SDK Codegen . Si desea obtener más información sobre cómo se genera nuestro código SDK, consulte este repositorio.

Licencia
Facebook Business SDK para Java tiene licencia bajo el archivo LICENSE en el directorio raíz de este árbol fuente.
