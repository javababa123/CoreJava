import java.util.*;
import com.ril.kafka.rest.client.RILKafkaRestClient;
import com.ril.kafka.rest.enums.RILMessageGroup;
import com.ril.notification.engine.Body;
import com.ril.notification.engine.CommunicationDetails;
import com.ril.notification.engine.Entry;
import com.ril.notification.engine.Header;
import com.ril.notification.engine.MessageContent;
import com.ril.notification.engine.Notification;
import com.ril.notification.engine.NotificationData;
import com.ril.notification.engine.NotificationType;
import com.ril.notification.engine.UnFormattedMessage;

public class NotificationEngineEmailSender {

	
	public static void main(String srgs[])
	{
	StringBuilder sb = new StringBuilder();
	sb.append("store.front1@servicesnext.com");
	//	sb.append(",");
	//	sb.append("gunjanestate@gmail.com");
	//	sb.append(",");
	//	sb.append("test.fnl3@servicesnext.com");
	NotificationData notificationdata = new NotificationData();
	Body body = new Body();
	Notification notification = new Notification();
	NotificationType notificationType = new NotificationType();
	notificationType.setEmail(true);
	//		 notificationType.setSms(true);
	notification.setNotificationType(notificationType);
	CommunicationDetails communicationDetails = new CommunicationDetails();
	communicationDetails.setMobileNo(919741257733L);
	communicationDetails.setToEmailId(sb.toString());
	//	 communicationDetails.setCcEmailId(" ");
	//	 communicationDetails.setBccEmailId("orderdetails@jio.com");
	communicationDetails.setSubject("Carrier Engine Pregen ");
	notification.setCommunicationDetails(communicationDetails);
	MessageContent messageContent = new MessageContent();
	UnFormattedMessage unMsg = new UnFormattedMessage();
	
	//unMsg.setEmailTemplateId("PREGENUPLOAD");
	unMsg.setEmailTemplateId("THRESHOLD");

	Map<CharSequence, CharSequence> keyValueMap = new HashMap<>();
	//	        keyValueMap.put("ImageURL", "https://10.129.49.47/medias/-60Wx75H-460001949-black-MODEL?context=bWFzdGVyfHJvb3R8NTg2M3xpbWFnZS9qcGVnfGgxZC9oZDgvODgxNDgxNTY0MTYzMC5qcGd8ZGM1MDg1MTY1M2IyMDE5MTI0NzI3NzAyODdjOGRmNmE3NzQ2ZWU5YTgyOTY4YjhjZTJmN2RkOTFmM2NmMjI5ZA");
	keyValueMap.put("name", "Ranveer");
	keyValueMap.put("tenant", "JIO");
	//keyValueMap.put("carrcode", "BLUEDART");
	//keyValueMap.put("status", "Completed");	
	unMsg.setKeyValueMap(keyValueMap);

	/*List<Entry> list = new ArrayList<Entry>();

	Entry entry = new Entry();
	Map<CharSequence, CharSequence> map = new HashMap<CharSequence, CharSequence>();
	map.put("srNo","1");
	map.put("carrierName","AJIO");
	map.put("orderType","PRE");
	map.put("paymentMethod","CASH");
	map.put("shippingMode","AIR");
	map.put("count","5");
	map.put("startAWB","100000");
	map.put("endAWB","1222222");
	map.put("thresholdValue","2000");
	
	entry.setKeyValueMap(map);
	list.add(entry);

	Entry entry2 = new Entry();
	Map<CharSequence, CharSequence> map2 = new HashMap<CharSequence, CharSequence>();
	map2.put("Colour", "TRUE");
	map2.put("Size","http://google.com");
	map2.put("productName","iphone X");
	map2.put("Qty","1");
	map2.put("Price","86,000/-");
	map2.put("SubTotal","87,000/-");
	entry2.setKeyValueMap(map2);
	list.add(entry2);
*/

	Map<CharSequence,List<Entry>> products= new HashMap<CharSequence,List<Entry>>();
	//emailDto.setEntries("orderEntry",list);
//	  products.put("thresholdList",tableMap);
	
	Map<CharSequence, List<Entry>> tableMap = new HashMap<>();
	  List<Entry> rows = new ArrayList<>();

	  Entry row1 = new Entry();
	  Map<CharSequence, CharSequence> row1Columns = new HashMap<>();
	  row1Columns.put("srNo", "Nawaz");
	  row1Columns.put("carrierName", "123");
	  row1Columns.put("orderType", "Mango");
	  row1Columns.put("paymentMethod", "1kg");
	  row1Columns.put("shippingMode", "1kg");
	  row1Columns.put("count", "1kg");
	  row1Columns.put("startAWB", "1kg");
	  row1Columns.put("endAWB", "1kg");
	  row1Columns.put("thresholdValue", "1kg");
			 
	  row1.setKeyValueMap(row1Columns);
	  rows.add(row1);

	  Entry row2 = new Entry();
	  Map<CharSequence, CharSequence> row2Columns = new HashMap<>();
	  row2Columns.put("srNo", "Nawa1z");
	  row2Columns.put("carrierName", "12123");
	  row2Columns.put("orderType", "Man2go");
	  row2Columns.put("paymentMethod", "31kg");
	  row2Columns.put("shippingMode", "14kg");
	  row2Columns.put("count", "1kg4");
	  row2Columns.put("startAWB", "41kg");
	  row2Columns.put("endAWB", "1kg2");
	  row2Columns.put("thresholdValue", "21kg");
	  row2.setKeyValueMap(row2Columns); 
	  rows.add(row2);

	  tableMap.put("thresholdList", rows);
	  unMsg.setRowMap(tableMap);

	messageContent.setUnFormattedMessage(unMsg);
	notification.setMessageContent(messageContent);
	//	  notification.setAttachmentURLs("NAS:/opt/invoicedata_sit/FIM_Registration_Password_Reset.pdf");
	//	  notification.setAttachmentURLs("FTP:/opt/ftpdata/UAT/internal/invoice/incoming/100163943_FL01880001.pdf");
	//	  notification.setAttachmentURLs("http://10.129.80.164/medias/Invoice_RDF00637053.pdf?context=bWFzdGVyfHJvb3R8MTE3MTY1fGFwcGxpY2F0aW9uL3BkZnxoZjkvaDgxLzg4NzYyMTA5MTMzMTAucGRmfGUzNDk1NTZiYjdjYTAxYTExMTdlMTAyZWQ0ZWE4YmRkZjNmMzU4ZmM3YWQxNThlYmE4Zjc5Yzk0MWE4YWVlNmY&attachment=true ");
	body.setNotification(notification);
	notificationdata.setBody(body);
	Header header = new Header();
	header.setDateTime(new Date().getTime());
	header.setMessageGroup(RILMessageGroup.GENERIC.name());
	header.setMessageType("CUSTOMERCUMMINICATION");
	header.setSourceSystem("NE");
	
	header.setTransactionId("123456");
	notificationdata.setHeader(header);
	
	//  notificationdata.setAppName("CARRIERENGINE");
	//  notificationdata.setAppKey("66CA084D70411DA002C601A623D4DC5656D91C4D5299965F60BC562702517C22");
	
		  notificationdata.setAppName("DIGITAL");
		  notificationdata.setAppKey("7EE2A6B61F9B208CC186D9CD2E111B10336C3BD6D1748C88E38D9B07984176C2");
//	notificationdata.setAppName("AJIO");
//	notificationdata.setAppKey("7CB4BDE41EED910C1CEC659225522E42BBE43A291764B2A4DCE5B9AE222C1D76");
	//	  notificationdata.setAppName("JIO");
	//	  notificationdata.setAppKey("5A3087BA3BA7F4B6C658C42F6CBA1DEB0F2DA33322A31200167EB63D7200B397");
	notificationdata.setEnterpriseId("EnterpriseID123");
	//	  service.sendNotification(notificationdata);
	//	  RILKafkaRestClient kafkaRestClient = RILKafkaRestClient.getInstance("http://10.131.4.77");
	RILKafkaRestClient kafkaRestClient = RILKafkaRestClient.getInstance("http://10.129.49.136:8082");  
	System.out.println(notificationdata.toString());
	System.out.println(kafkaRestClient.push(notificationdata));
	}
}
