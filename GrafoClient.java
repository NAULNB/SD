/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

/**
 *
 * @author Luan
 */

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class GrafoClient {

  public static void main(String [] args) {

    if (args.length != 1) {
      System.out.println("Please enter 'simple' or 'secure'");
      System.exit(0);
    }

    try {
      TTransport transport;
      if (args[0].contains("simple")) {
        transport = new TSocket("localhost", 2790);
        transport.open();
      }
      else {
        /*
         * Similar to the server, you can use the parameters to setup client parameters or
         * use the default settings. On the client side, you will need a TrustStore which
         * contains the trusted certificate along with the public key. 
         * For this example it's a self-signed cert. 
         */
        TSSLTransportParameters params = new TSSLTransportParameters();
        params.setTrustStore("../../lib/java/test/.truststore", "thrift", "SunX509", "JKS");
        /*
         * Get a client transport instead of a server transport. The connection is opened on
         * invocation of the factory method, no need to specifically call open()
         */
        transport = TSSLTransportFactory.getClientSocket("localhost", 9091, 0, params);
      }

      TProtocol protocol = new  TBinaryProtocol(transport);
      Grafo.Client client = new Grafo.Client(protocol);

      perform(client);

      transport.close();
    } catch (TException x) {
      x.printStackTrace();
    } 
  }

  private static void perform(Grafo.Client client) throws TException
  {
   
    
      int i;
      i= client.GerVertice(1, 27, "Primeiro Vertice", 2.25, 1);
      client.GerVertice(1,0,"",0,2);
      i= client.GerVertice(2, 27, "Segundo Vertice", 7.25, 1);
      client.GerVertice(2,0,"",0,2);
      
      i=client.GerAresta(1, 2, 13.3, "1", "primeira aresta", 1);
      client.GerAresta(0,0,0,"", "primeira aresta", 2);
      
      
      
      
      
  }
}
