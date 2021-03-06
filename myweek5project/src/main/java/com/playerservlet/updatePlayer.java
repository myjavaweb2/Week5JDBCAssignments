package com.playerservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nbaplayer.DAO;
import com.nbaplayer.Player;

/**
 * Servlet implementation class updatePlayer
 */
@WebServlet("/updatePlayer")
public class updatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Player updatePlayer = new Player();
		
		updatePlayer.setPlayerID(request.getParameter("player_id"));
		updatePlayer.setFirstName(request.getParameter("first_name"));
		updatePlayer.setLastName(request.getParameter("last_name"));
		updatePlayer.setCurrentLastTeam(request.getParameter("current_last_team"));
		updatePlayer.setPosition(request.getParameter("position"));
		updatePlayer.setTotalPoints(Integer.parseInt(request.getParameter("total_points")));
		updatePlayer.setChampionshipsWon(Integer.parseInt(request.getParameter("championships_won")));
		updatePlayer.setMvpWon(Integer.parseInt(request.getParameter("mvp_won")));
		
		DAO.updateToDB(updatePlayer);
		
		request.getRequestDispatcher("indexplayer.html").forward(request, response);

	}//doPost

}//class
