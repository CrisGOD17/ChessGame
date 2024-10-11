package piece;

import main.GamePanel;

public class Pawn extends Piece {

	public Pawn(int color, int col, int row) {
		super(color, col, row);

		if (color == GamePanel.WHITE) {
			image = getImage("/piece/w-pawn");
		} else {

			image = getImage("/piece/b-pawn");

		}

	}

	public boolean canMove(int targetCol, int targetRow) {

		if (isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {

			// define a donde se mueve dependiendo de su color
			int moveValue;
			if (color == GamePanel.WHITE) {
				moveValue = -1;
			} else {

				moveValue = 1;

			}

			// checa la pieza que esta golpeando enfrente de esta

			hittingP = getHittingP(targetCol, targetRow);

			// movimiento de un cuadrado

			if (targetCol == preCol && targetRow == preRow + moveValue && hittingP == null) {
				return true;
			}

			// movimiento de dos cuadrados
			if (targetCol == preCol && targetRow == preRow + moveValue * 2 && hittingP == null && moved == false
					&& pieceIsOnStraightLine(targetCol, targetRow) == false) {
				return true;
			}

			// movimiento diagonal y captura si una pieza esta en diagonal y enfrente de
			// ella

			if (Math.abs(targetCol - preCol) == 1 && targetRow == preRow + moveValue && hittingP != null
					&& hittingP.color != color) {
				return true;
			}

		}

		return false;

	}
}
