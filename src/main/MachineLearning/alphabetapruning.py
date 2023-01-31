# Alpha beta puring
# Here I consider alpha as max node & beta as a min node 
MAX, MIN = 1000, -1000

class AlphaBethaPruning:
    def __init__(self) -> None:
        pass
    def minimax(depth, nodeIndex, maximizingPlayer,
			values, alpha, beta):
            if depth == 3:
                return values[nodeIndex]
            if maximizingPlayer:
                best = MIN
                for i in range(0, 2):
                    val = AlphaBethaPruning.minimax(depth + 1, nodeIndex * 2 + i,False, values, alpha, beta)
                    best = max(best, val)
                    alpha = max(alpha, best)

                    if beta <= alpha:
                        break
                return best
            else:
                best = MAX
                for i in range(0, 2):
                    val =AlphaBethaPruning.minimax(depth + 1, nodeIndex * 2 + i,True, values, alpha, beta)
                    best = min(best, val)
                    beta = min(beta, best)
                    if beta <= alpha:
                        break
                return best

	
if __name__ == "__main__":

	values = [1, 4, 6, 9, 1, 2, 4, -1]
	print("The optimal solution is :",AlphaBethaPruning.minimax(0, 0, True, values, MIN, MAX))
	
