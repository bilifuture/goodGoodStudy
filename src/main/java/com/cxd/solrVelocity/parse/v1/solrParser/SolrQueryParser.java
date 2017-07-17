package com.cxd.solrVelocity.parse.v1.solrParser;

import com.cxd.solrVelocity.utils.BeanUtil;
import com.cxd.solrVelocity.statement.SolrStatement;
import org.apache.velocity.VelocityContext;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by childe on 2017/7/16.
 */
public class SolrQueryParser {

    public static String parse(SolrStatement statement, Object o) {
        Map<String,Object> param = new HashMap<>();
        param = BeanUtil.populateMap(param,o);
        VelocityContext context = new VelocityContext(param);
        Writer writer = new StringWriter();
        VelocityEngineFactory.newVelocityEngine().evaluate(context,writer,statement.getKey(),statement.getStatement());
        return writer.toString();
    }
}
