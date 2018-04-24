package snlJavaApiTest;

import org.testng.annotations.Test;

import com.qainfotech.tap.training.snl.api.Board;
import com.qainfotech.tap.training.snl.api.GameInProgressException;
import com.qainfotech.tap.training.snl.api.MaxPlayersReachedExeption;
import com.qainfotech.tap.training.snl.api.PlayerExistsException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class BoardTest {

	// @Test
	public void parameterizdBoardTest() {
		try {
			Board board = new Board();
			try {
				board.registerPlayer("Priya");
			} catch (PlayerExistsException | GameInProgressException | MaxPlayersReachedExeption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Test Case For MaxPlayersReachedException Class */
	@Test
	public void maxPlayersReachedExceptionTest() {
		MaxPlayersReachedExeption maxPlayerReachedException = new MaxPlayersReachedExeption(11);
		Assert.assertEquals("The board already has maximum allowed Player: " + 11,
				maxPlayerReachedException.getMessage());

	}

	/* Test Case For GameInProgressException Class */
	@Test
	public void gameInProgressExceptionTest() {
		GameInProgressException gameInProgressException = new GameInProgressException();
		Assert.assertEquals("New player cannot join since the game has started", gameInProgressException.getMessage());
	}

	/* Test Cases For registerPlayer Method */
	@Test
	public void registeredPlayerTestPosition() {
		try {
			Board board = new Board();
			try {
				JSONArray newplayer = board.registerPlayer("shikha");
				JSONObject json = (JSONObject) newplayer.get(0);
				System.out.println("0000000000000000000000000000000" + json.get("position"));
				Assert.assertEquals(0, json.get("position"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void registeredPlayerTestName() {
		try {
			Board board = new Board();
			try {
				String name = "shikha";
				JSONArray newplayer = board.registerPlayer("shikha");
				JSONObject json = (JSONObject) newplayer.get(0);
				System.out.println(json.get("name"));
				Assert.assertEquals("shikha", json.get("name"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void registeredPlayerTestOnUuid() {
		try {
			Board board = new Board();
			String regex = "^[a-zA-Z0-9-]*$";
			try {
				String name = "shikha";
				JSONArray newplayer = board.registerPlayer("kavita");
				JSONObject json = (JSONObject) newplayer.get(0);
				System.out.println(json.get("uuid")+"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				//Assert.assertEquals("shikha", json.get("uuid"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
