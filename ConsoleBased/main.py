from player import *
from game import *

if __name__ == "__main__":
    # Human vs AIComputer
    # x_player = HumanPlayer('X')
    # o_player = AIComputerPlayer('O')
    # t = TicTacToe()
    # play(t, x_player, o_player, print_game=True)

    # RandomComputer vs AIComputer 
    x_player = RandomComputerPlayer('X')
    o_player = AIComputerPlayer('O')
    t = TicTacToe()
    play(t, x_player, o_player, print_game=True)

