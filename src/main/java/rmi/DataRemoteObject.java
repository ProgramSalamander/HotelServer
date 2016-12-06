package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import objects.Client;
import objects.Hotel;
import objects.HotelStrategy;
import objects.HotelWorker;
import objects.OrderState;
import objects.ResultMessage;
import objects.RoomType;
import objects.VIPInfo;
import objects.WebStrategy;
import service.blservice.ClientBLService;
import service.blservice.HotelBLService;
import service.blservice.ManageBLService;
import service.blservice.OrderBLService;
import service.blservice.StrategyBLService;
import service.blservice.Impl.ClientBLServiceImpl;
import service.blservice.Impl.HotelBLServiceImpl;
import service.blservice.Impl.ManageBLServiceImpl;
import service.blservice.Impl.OrderBLServiceImpl;
import service.blservice.Impl.StrategyBLServiceImpl;
import vo.AccommodationVO;
import vo.ClientVO;
import vo.EvaluationVO;
import vo.HotelStrategyVO;
import vo.HotelVO;
import vo.HotelWorkerVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.WebMarketVO;
import vo.WebStrategyVO;

public class DataRemoteObject extends UnicastRemoteObject 
 	implements ClientBLService,HotelBLService,ManageBLService,OrderBLService,StrategyBLService{
	
	private static final long serialVersionUID = 4029039744279087114L;
	private ClientBLService clientbl;
	private HotelBLService hotelbl;
	private ManageBLService managebl;
	private OrderBLService orderbl;
	private StrategyBLService strategybl;
	protected DataRemoteObject() throws RemoteException {
		super();
		clientbl=new ClientBLServiceImpl();
		hotelbl=new HotelBLServiceImpl();
		managebl=new ManageBLServiceImpl();
		orderbl=new OrderBLServiceImpl();
		strategybl=new StrategyBLServiceImpl();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public ResultMessage hotelstrategy_make(HotelStrategyVO strategyvo) throws RemoteException {
		// TODO Auto-generated method stub
		return strategybl.hotelstrategy_make(strategyvo);
	}

	@Override
	public ResultMessage hotelstrategy_update(HotelStrategyVO strategyvo) throws RemoteException {
		// TODO Auto-generated method stub
		return strategybl.hotelstrategy_update(strategyvo);
	}

	@Override
	public ResultMessage webstrategy_make(WebStrategyVO strategyvo) throws RemoteException {
		// TODO Auto-generated method stub
		return strategybl.webstrategy_make(strategyvo);
	}

	@Override
	public ResultMessage webstrategy_update(WebStrategyVO strategyvo) throws RemoteException {
		// TODO Auto-generated method stub
		return strategybl.webstrategy_update(strategyvo);
	}

	@Override
	public ArrayList<HotelStrategyVO> getStrategy(int hotelid, int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return strategybl.getStrategy(hotelid, clientid);
	}

	@Override
	public ArrayList<WebStrategyVO> getStrategy(int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return strategybl.getStrategy(clientid);
	}

	@Override
	public ArrayList<OrderVO> order_client_browse(int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_client_browse(clientid);
	}

	@Override
	public ArrayList<OrderVO> order_client_browse(int clientid, String state) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_client_browse(clientid, state);
	}

	@Override
	public ArrayList<OrderVO> order_client_browse(int clientid, boolean isExecute) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_client_browse(clientid, isExecute);
	}

	@Override
	public ArrayList<OrderVO> order_hotel_browse(int hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_hotel_browse(hotelid);
	}

	@Override
	public ArrayList<OrderVO> order_hotel_browse(int hotelid, String state) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_hotel_browse(hotelid, state);
	}

	@Override
	public ArrayList<OrderVO> order_hotel_browse(int hotelid, boolean isExecute) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_hotel_browse(hotelid, isExecute);
	}

	@Override
	public ResultMessage order_client_cancel(int clientid, int orderid) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_client_cancel(clientid, orderid);
	}

	@Override
	public ResultMessage order_client_generate(OrderVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_client_generate(vo);
	}

	@Override
	public ResultMessage order_hotel_execute(int orderid) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_hotel_execute(orderid);
	}

	@Override
	public ArrayList<OrderVO> order_market_browseUnfilled() throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_market_browseUnfilled();
	}

	@Override
	public ResultMessage order_market_cancelAbnormal(int orderid) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.order_market_cancelAbnormal(orderid);
	}

	@Override
	public int calculateTotalwithoutStrategy(RoomType type, int num) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.calculateTotalwithoutStrategy(type, num);
	}

	@Override
	public int calculateTotalwithStrategy(RoomType type, int num, ArrayList<HotelStrategyVO> list1,
			ArrayList<WebStrategyVO> list2) throws RemoteException {
		// TODO Auto-generated method stub
		return orderbl.calculateTotalwithStrategy(type, num, list1, list2);
	}

	@Override
	public ResultMessage updateActualLeaveTime(int orderid, String leaveTime) {
		// TODO Auto-generated method stub
		return orderbl.updateActualLeaveTime(orderid, leaveTime);
	}

	@Override
	public ClientVO manage_searchClient(int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return managebl.manage_searchClient(clientid);
	}

	@Override
	public ResultMessage manage_updateClient(ClientVO clientvo) throws RemoteException {
		// TODO Auto-generated method stub
		return managebl.manage_updateClient(clientvo);
	}

	@Override
	public ResultMessage manage_addHotel(HotelVO hotelvo) throws RemoteException {
		// TODO Auto-generated method stub
		return managebl.manage_addHotel(hotelvo);
	}

	@Override
	public ResultMessage manage_addHotelWorker(HotelWorkerVO w) throws RemoteException {
		// TODO Auto-generated method stub
		return managebl.manage_addHotelWorker(w);
	}

	@Override
	public HotelWorkerVO manage_searchHotelWorker(int hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		return managebl.manage_searchHotelWorker(hotelid);
	}

	@Override
	public ResultMessage manage_updateHotelWorker(HotelWorkerVO w) throws RemoteException {
		// TODO Auto-generated method stub
		return managebl.manage_updateHotelWorker(w);
	}

	@Override
	public ResultMessage manage_addMarketWorker(WebMarketVO mw) throws RemoteException {
		// TODO Auto-generated method stub
		return managebl.manage_addMarketWorker(mw);
	}

	@Override
	public WebMarketVO manage_searchMarketWorker(int marketWorkerid) throws RemoteException {
		// TODO Auto-generated method stub
		return managebl.manage_searchMarketWorker(marketWorkerid);
	}

	@Override
	public ResultMessage manage_updateMarketWorker(WebMarketVO mw) throws RemoteException {
		// TODO Auto-generated method stub
		return managebl.manage_updateMarketWorker(mw);
	}

	@Override
	public HotelVO hotel_checkInfo(int hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelbl.hotel_checkInfo(hotelid);
	}

	@Override
	public ResultMessage hotel_updateInfo(HotelVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelbl.hotel_updateInfo(vo);
	}

	@Override
	public ResultMessage hotel_importRoom(RoomVO room) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelbl.hotel_importRoom(room);
	}

	@Override
	public ResultMessage hotel_updateAccomodation(AccommodationVO info) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelbl.hotel_updateAccomodation(info);
	}

	@Override
	public Hotel searchHotel(int hotelid) {
		// TODO Auto-generated method stub
		return hotelbl.searchHotel(hotelid);
	}

	@Override
	public ArrayList<Hotel> previousHotel(int clientid) {
		// TODO Auto-generated method stub
		return hotelbl.previousHotel(clientid);
	}

	@Override
	public ResultMessage addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelbl.addHotel(hotel);
	}

	@Override
	public ResultMessage addHotelWorker(HotelWorker worker) {
		// TODO Auto-generated method stub
		return hotelbl.addHotelWorker(worker);
	}

	@Override
	public HotelWorker searchHotelWorker(int hotelid) {
		// TODO Auto-generated method stub
		return hotelbl.searchHotelWorker(hotelid);
	}

	@Override
	public ResultMessage updateHotelWokerInfo(int hotelid, HotelWorker worker) {
		// TODO Auto-generated method stub
		return hotelbl.updateHotelWokerInfo(hotelid, worker);
	}

	@Override
	public ClientVO client_checkInfo(int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_checkInfo(clientid);
	}

	@Override
	public ResultMessage client_updateInfo(ClientVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_updateInfo(vo);
	}

	@Override
	public ArrayList<HotelVO> client_getpreviousHotelList(int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_getpreviousHotelList(clientid);
	}

	@Override
	public int client_checkCredit(int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_checkCredit(clientid);
	}

	@Override
	public ArrayList<String> client_checkCreditList(int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_checkCreditList(clientid);
	}

	@Override
	public ArrayList<HotelVO> client_setLocation(String location) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_setLocation(location);
	}

	@Override
	public ArrayList<HotelVO> client_searchHotel(String hotelname) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_searchHotel(hotelname);
	}

	@Override
	public ArrayList<HotelVO> client_searchHotel(RoomType type) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_searchHotel(type);
	}

	@Override
	public ArrayList<HotelVO> client_searchHotel(int lowprice, int highprice) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_searchHotel(lowprice, highprice);
	}

	@Override
	public ArrayList<HotelVO> client_searchHotel(String inTime, String leaveTime) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_searchHotel(inTime, leaveTime);
	}

	@Override
	public ArrayList<HotelVO> client_searchHotel(int star) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_searchHotel(star);
	}

	@Override
	public ArrayList<HotelVO> client_searchHotel(double lowscore, double highscore) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_searchHotel(lowscore, highscore);
	}

	@Override
	public HotelVO client_checkHotelInfo(int hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_checkHotelInfo(hotelid);
	}

	@Override
	public ResultMessage client_evaluateHotel(EvaluationVO e, int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_evaluateHotel(e, clientid);
	}

	@Override
	public ResultMessage client_enrollVIP(VIPInfo info, int clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return clientbl.client_enrollVIP(info, clientid);
	}

	@Override
	public ResultMessage updateClientCredit(int clientId, int value, int tag) {
		// TODO Auto-generated method stub
		return clientbl.updateClientCredit(clientId, value, tag);
	}

	@Override
	public Client checkClientInfo(int clientid) {
		// TODO Auto-generated method stub
		return clientbl.checkClientInfo(clientid);
	}

	@Override
	public ResultMessage updateClientInfo(Client client) {
		// TODO Auto-generated method stub
		return clientbl.updateClientInfo(client);
	}

}
