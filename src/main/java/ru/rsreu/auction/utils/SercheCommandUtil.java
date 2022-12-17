package ru.rsreu.auction.utils;

import ru.rsreu.auction.command.Command;
import ru.rsreu.auction.command.UnknownCommand;
import ru.rsreu.auction.constant.GlobalConst;

import javax.servlet.http.HttpServletRequest;

public class SercheCommandUtil {
	public static String COMMAND_PATH_FORMAT = "ru.rsreu.auction.command.%sCommand";

	public static Command getCommand(HttpServletRequest request) {
		try {
			String param = request.getParameter(GlobalConst.PARAMS_PAGE);
			String commandName = String.format(
					COMMAND_PATH_FORMAT,
					param.substring(0, 1).toUpperCase() + param.substring(1)
			);
			Class<?> type = Class.forName(commandName);
			return type
					.asSubclass(Command.class)
					.newInstance();
		} catch (Exception e) {
			return new UnknownCommand();
		}
	}
}
