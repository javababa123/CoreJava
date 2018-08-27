import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.SimpleQueryStringBuilder;
import org.elasticsearch.index.query.WrapperQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ElasticSearch {

	
	public static void main(String args[]) throws UnknownHostException, JSONException
	{
		
		JSONObject query=new JSONObject();		
		JSONObject boolHead= new JSONObject();
		JSONArray should = new JSONArray();
		JSONObject shouldObj = new JSONObject();		
		JSONObject bool = new JSONObject();
		JSONArray must = new JSONArray();
		JSONObject matchObj=new JSONObject();
		JSONObject match2Obj=new JSONObject();
		JSONObject match3Obj=new JSONObject();		
		matchObj.put("match",new JSONObject().put("tenant_id", "JIO"));
		match2Obj.put("match", new JSONObject().put("carr_code", "DELHIVERY"));
		match3Obj.put("match", new JSONObject().put("to_zipcode", "560037"));
		must.put(matchObj);
		must.put(match2Obj);
		must.put(match3Obj);
		bool.put("must", must);
		shouldObj.put("bool", bool);
		should.put(shouldObj);
		boolHead.put("should", should);
		query.put("bool", boolHead);
		System.out.println(query.toString());
		
		Settings settings = Settings.builder()
		        .put("cluster.name", "elastic-engine").build();
		TransportClient client = new PreBuiltTransportClient(settings)	
		        .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

		System.out.println("connected");
		//String jsonQueryDef="{\"bool\":{ \"should\":[ { \"bool\":{ \"must\":[ { \"match\":{ \"tenant_id\":\"JIO\" } }, { \"match\":{ \"carr_code\":\"DELHIVERY\" } }, { \"match\":{ \"to_zipcode\":\"560037\" } } ] } }] }  }";		
		
		long st =System.currentTimeMillis();
		WrapperQueryBuilder ss =QueryBuilders.wrapperQuery(query.toString());;
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(ss);
		SearchResponse response =
				client.prepareSearch("admcarrierdet").setTypes("ADM_CARRIER_DET")
				.setSource(searchSourceBuilder).setFrom(0).setSize(1).setExplain(false)
				.execute()
				.actionGet();
		long ed =System.currentTimeMillis();
		System.out.println("duration: "+ (ed-st));
		System.out.println("Response: "+response);
		
		/// on shutdown
		client.close();
	}
}
