/**
 *
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.WsagParser;
import es.us.isa.aml.translators.Translator;
import es.us.isa.aml.translators.iagree.IAgreeBuilder;

/**
 * @author jdelafuente
 *
 */
public class ParserTest {

	private static final Logger LOG = Logger.getLogger(ParserTest.class
			.getName());

	public static void main(String[] args) {

//		InputStream in = ParserTest.class
//				.getResourceAsStream("/samples/iagree-core.at");
		
		InputStream in = ParserTest.class
				.getResourceAsStream("/samples/wsag.xml");
		
		String content = getStringFromInputStream(in);		

//		IAgreeParser parser = new IAgreeParser();
//		AgreementModel model = parser.doParse(content);

//		if (parser.getErrorListener().hasErrors()) {
//			LOG.severe(parser.getErrorListener().getErrors().toString());
//		} else {
//			System.out.println(model.toString()); /* LOG.info(model.toString()); */
//		}

//		Translator t = new Translator(new WSAGBuilder());
//		System.out.println(t.export(model));
		
		WsagParser parser = new WsagParser();
		AgreementModel model = parser.doParse(content);
		
//		Translator t = new Translator(new WSAGBuilder());
//		System.out.println(t.export(model));
//		
		Translator t = new Translator(new IAgreeBuilder());
		System.out.println(t.export(model));
		
		
		System.out.println(model.getProperty("MonitProp1"));
		model.setProperty("MonitProp1", 62);
		System.out.println(model.getProperty("MonitProp1").intValue());
		System.out.println("Evaluate: " + model.evaluateGT("G1"));
		model.setProperty("MonitProp1", 64);
		System.out.println("Evaluate: " + model.evaluateGT("G1"));
		
	}

	public static String getStringFromInputStream(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line.replaceAll("	", "\t")).append("\n");
			}
		} catch (IOException e) {
			LOG.log(Level.WARNING, null, e);
		}
		return sb.toString();
	}

}
