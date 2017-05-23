namespace java projetofinal

service Grafo
{
                i32 GerVertice(1:i32 nome,2:i32 cor,3:string descricao,4:double peso,5:i32 tpOperacao),
		i32 GerAresta(1:i32 v1,2:i32 v2,3:double peso,4:string direcao,5:string descricao,6:i32 tpOperacao),
                i32 ListaArestas(1:i32 vertice),
		i32 ListaVertices(1:string aresta),
		i32 ListarVizinhos(1:i32 v),
		i32 MenorCaminho(1:i32 origem,2:i32 destino)
		}