from collections import defaultdict
graph=defaultdict(list)
def addEdge(graph,u,v):
    graph[u].append(v)
def generate_edges(graph):
    edges=[]
    for node in graph:
        for neighbour in graph[node]:
            edges.append((node,neighbour))
    return edges
if __name__ == '__main__':
    addEdge(graph,'a','b')
    addEdge(graph,'b','c')
    addEdge(graph,'c','d')
    addEdge(graph,'d','a')
    print(generate_edges(graph))
