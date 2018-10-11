package com.zkh.storm.hbase;

import java.util.Map;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.IBasicBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class AreaFilterBolt implements IBasicBolt {
	private static final long serialVersionUID = 1L;
	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void prepare(Map stormConf, TopologyContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		// TODO Auto-generated method stub
	    byte[] juzi = (byte[]) input.getValueByField("bytes");
	    System.err.println("AreaFilterBolt:"+new String(juzi));
		String order = new String(juzi);
		if(order != null){
			String[] arr = order.split("\\t");
			//area_id.order_amt,order_date
			collector.emit(new Values(arr[3],arr[1],arr[2]));
		}
	}
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("area_id","order_amt","order_date"));
		//area_id,order_amt,order_date
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
