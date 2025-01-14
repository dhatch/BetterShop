/**
 * Copyright (C) 2011 Jacob Scott <jascottytechie@gmail.com>
 * Description: methods for working with & formatting strings in minecraft chat
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.jascotty2.lib.bukkit;

import me.jascotty2.lib.util.Str;
import java.util.LinkedList;
import org.bukkit.ChatColor;

public class MinecraftChatStr {

	public final static int chatwidth = 318; // 325
	public static String charWidthIndexIndex =
			" !\"#$%&'()*+,-./"
			+ "0123456789:;<=>?"
			+ "@ABCDEFGHIJKLMNO"
			+ "PQRSTUVWXYZ[\\]^_"
			+ "'abcdefghijklmno"
			+ "pqrstuvwxyz{|}~⌂"
			+ "ÇüéâäàåçêëèïîìÄÅ"
			+ "ÉæÆôöòûùÿÖÜø£Ø×ƒ"
			+ "áíóúñÑªº¿®¬½¼¡«»";
	public static int[] charWidths = {
		4, 2, 5, 6, 6, 6, 6, 3, 5, 5, 5, 6, 2, 6, 2, 6,
		6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 2, 2, 5, 6, 5, 6,
		7, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 6, 6, 6, 6, 6,
		6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 4, 6, 6,
		3, 6, 6, 6, 6, 6, 5, 6, 6, 2, 6, 5, 3, 6, 6, 6,
		6, 6, 6, 6, 4, 6, 6, 6, 6, 6, 6, 5, 2, 5, 7, 6,
		6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 3, 6, 6,
		6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6,
		6, 3, 6, 6, 6, 6, 6, 6, 6, 7, 6, 6, 6, 2, 6, 6,
		// not sure what tkelly made these rows for..
		8, 9, 9, 6, 6, 6, 8, 8, 6, 8, 8, 8, 8, 8, 6, 6,
		9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
		9, 9, 9, 9, 9, 9, 9, 9, 9, 6, 9, 9, 9, 5, 9, 9,
		8, 7, 7, 8, 7, 8, 8, 8, 7, 8, 8, 7, 9, 9, 6, 7,
		7, 7, 7, 7, 9, 6, 7, 8, 7, 6, 6, 9, 7, 6, 7, 1};
	// chat limmitation: repetitions of characters is limmited to 119 per line
	//      so: repeating !'s will not fill a line

	public static int getStringWidth(String s) {
		int i = 0;
		if (s != null) {
			s = s.replaceAll("\\u00A7.", "");
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) >= 0) {
					i += getCharWidth(s.charAt(j));
				}
			}
		}
		return i;
	}

	public static int getCharWidth(char c) {
		//return getCharWidth(c, 0);
		int k = charWidthIndexIndex.indexOf(c);
		if (c != '\247' && k >= 0) {
			return charWidths[k];
		}
		return 0;
	}

	public static int getCharWidth(char c, int defaultReturn) {
		int k = charWidthIndexIndex.indexOf(c);
		if (c != '\247' && k >= 0) {
			return charWidths[k];
		}
		return defaultReturn;
	}

	public static String uncoloredStr(String s) {
		//return s != null ? s.replaceAll("\\u00A7.", "") : s;
		//s.replaceAll("\\\u00A7.", "")
		return s == null ? null : ChatColor.stripColor(s);
	}

	/**
	 * pads str on the right with spaces (left-align)
	 * @param str string to format
	 * @param len spaces to pad
	 * @return str with padding appended
	 */
	public static String padRight(String str, int len) {
		return padRight(str, len, ' ');
	}

	/**
	 * pads str on the right with pad (left-align)
	 * @param str string to format
	 * @param len spaces to pad
	 * @param pad character to use when padding
	 * @return str with padding appended
	 */
	public static String padRight(String str, int len, char pad) {
		// for purposes of this function, assuming a normal char to be 6
		len *= 6;
		len -= getStringWidth(str);
		return str + Str.repeat(pad, len / getCharWidth(pad, 6));
	}

	/**
	 * pads str on the right to # of pixels
	 * @param str string to format
	 * @param pad character to use when padding
	 * @param abslen pixels to space out
	 * @return
	 */
	public static String padRight(String str, char pad, int abslen) {
		abslen -= getStringWidth(str);
		return str + Str.repeat(pad, abslen / getCharWidth(pad, 6));
	}

//	public static String strPadRightChat(String str, int abslen) {
//		abslen -= getStringWidth(str);
//		return str + Str.repeat(' ', abslen / getCharWidth(' ', 6));
//	}

	public static String padRight(String str, char pad) {
		int width = chatwidth - getStringWidth(str);
		return str + Str.repeat(pad, width / getCharWidth(pad, 6));
	}

	public static String padRight(String str) {
		int width = chatwidth - getStringWidth(str);
		return str + Str.repeat(' ', width / getCharWidth(' ', 6));
	}

	/**
	 * pads str on the left with pad (right-align)
	 * @param str string to format
	 * @param len spaces to pad
	 * @param pad character to use when padding
	 * @return str with padding prepended
	 */
	public static String padLeft(String str, int len, char pad) {
		// for purposes of this function, assuming a normal char to be 6
		len *= 6;
		len -= getStringWidth(str);
		return Str.repeat(pad, len / getCharWidth(pad, 6)) + str;
	}

	public static String padLeft(String str, char pad, int abslen) {
		abslen -= getStringWidth(str);
		return Str.repeat(pad, abslen / getCharWidth(pad, 6)).concat(str);
	}

//	public static String strPadLeftChat(String str, int abslen) {
//		abslen -= getStringWidth(str);
//		return Str.repeat(' ', abslen / getCharWidth(' ', 6)).concat(str);
//	}

	public static String padLeft(String str, char pad) {
		int width = chatwidth - getStringWidth(str);
		return Str.repeat(pad, width / getCharWidth(pad, 6)).concat(str);
	}

	public static String padLeft(String str) {
		int width = chatwidth - getStringWidth(str);
		return Str.repeat(' ', width / getCharWidth(' ', 6)).concat(str);
	}

	/**
	 * pads str on the left & right with pad (center-align)
	 * @param str string to format
	 * @param len spaces to pad
	 * @param pad character to use when padding
	 * @return str centered with pad
	 */
	public static String padCenter(String str, int len, char pad) {
		// for purposes of this function, assuming a normal char to be 6
		len *= 6;
		len -= getStringWidth(str);
		int padwid = getCharWidth(pad, 6);
		int prepad = (len / padwid) / 2;
		len -= prepad * padwid;
		return Str.repeat(pad, prepad) + str + Str.repeat(pad, len / padwid);
	}

	/**
	 * pads str on the left & right to # of pixels with pad (center-align)
	 * @param str string to format
	 * @param pad character to use when padding
	 * @param abslen pixels to make the result string
	 * @return
	 */
	public static String padCenter(String str, char pad, int abslen) {
		abslen -= getStringWidth(str);
		int padwid = getCharWidth(pad, 6);
		int prepad = (abslen / padwid) / 2;
		abslen -= prepad * padwid;
		return Str.repeat(pad, prepad) + str + Str.repeat(pad, abslen / padwid);
	}

	public static String padCenter(String str, char pad) {
		int width = chatwidth - getStringWidth(str);
		int padwid = getCharWidth(pad, 6);
		int prepad = (width / padwid) / 2;
		width -= prepad * padwid;
		return Str.repeat(pad, prepad) + str + Str.repeat(pad, width / padwid);
	}

	public static int strLen(String str) {
		return str == null ? -1 : ChatColor.stripColor(str).length();
//        if (!str.contains("\u00A7")) {
//            return str.length();
//        }
//        // just searching for \u00A7.
//        return str.replaceAll("\\u00A7.", "").length();
	}

	public static String strTrim(String str, int length) {
		if (uncoloredStr(str).length() > length) {
			int width = length;
			String ret = "";
			boolean lastCol = false;
			for (char c : str.toCharArray()) {
				if (c == '\u00A7') {
					ret += c;
					lastCol = true;
				} else {
					if (!lastCol) {
						if (width - 1 >= 0) {
							width -= 1;
							ret += c;
						} else {
							return ret;
						}
					} else {
						ret += c;
						lastCol = false;
					}
				}
			}
		}
		return str;
	}

	public static String strChatTrim(String str) {
		return strChatTrim(str, chatwidth);
	}

	public static String strChatTrim(String str, int absLen) {
		int width = getStringWidth(str);
		if (width > absLen) {
			width = absLen;
			String ret = "";
			boolean lastCol = false;
			for (char c : str.toCharArray()) {
				if (c == '\u00A7') {
					ret += c;
					lastCol = true;
				} else {
					if (!lastCol) {
						int w = getCharWidth(c);
						if (width - w >= 0) {
							width -= w;
							ret += c;
						} else {
							return ret;
						}
					} else {
						ret += c;
						lastCol = false;
					}
				}
			}
		}
		return str;
	}

	public static String strWordWrap(String str) {
		return strWordWrap(str, 0, ' ');
	}

	public static String strWordWrap(String str, int tab) {
		return strWordWrap(str, tab, ' ');
	}

	public static String strWordWrap(String str, int tab, char tabChar) {
		String ret = "";
		while (str.length() > 0) {
			// find last char of first line
			if (getStringWidth(str) <= chatwidth) {
				return (ret.length() > 0 ? ret + "\n" + lastStrColor(ret) + Str.repeat(tabChar, tab) : "").concat(str);
			}
			String line1 = strChatTrim(str);
			int lastPos = line1.length() - (ret.length() > 0 ? tab + 1 : 1);
			while (lastPos > 0 && line1.charAt(lastPos) != ' ') {
				--lastPos;
			}
			if (lastPos == 0) {
				lastPos = line1.length() - (ret.length() > 0 ? tab + 1 : 1);
			}
			//ret += strPadRightChat((ret.length() > 0 ? unformattedStrRepeat(tabChar, tab) : "") + str.substring(0, lastPos));
			ret += (ret.length() > 0 ? "\n" + Str.repeat(tabChar, tab) + lastStrColor(ret) : "") + str.substring(0, lastPos);
			str = str.substring(lastPos + 1);
		}
		return ret;
	}

	public static String strWordWrapRight(String str, int tab) {
		return strWordWrapRight(str, tab, ' ');
	}

	/**
	 * right-aligns paragraphs
	 * @param str
	 * @param tab
	 * @param tabChar
	 * @return
	 */
	public static String strWordWrapRight(String str, int tab, char tabChar) {
		String ret = "";
		while (str.length() > 0) {
			// find last char of first line
			if (getStringWidth(str) <= chatwidth) {
				return (ret.length() > 0 ? ret + "\n" + lastStrColor(ret) : "").concat(padLeft(str, tabChar));
			}
			String line1 = strChatTrim(str);
			int lastPos = line1.length() - (ret.length() > 0 ? tab + 1 : 1);
			while (lastPos > 0 && line1.charAt(lastPos) != ' ') {
				--lastPos;
			}
			if (lastPos == 0) {
				lastPos = line1.length() - (ret.length() > 0 ? tab + 1 : 1);
			}
			//ret += strPadLeftChat(str.substring(0, lastPos), tabChar);
			ret += (ret.length() > 0 ? "\n" + lastStrColor(ret) : "") + padLeft(str.substring(0, lastPos), tabChar);
			str = str.substring(lastPos + 1);
		}
		return ret;
	}

	/**
	 * will left-align the start of the string until sepChar, then right-align the remaining paragraph
	 * @param str
	 * @param tab
	 * @param tabChar
	 * @param sepChar
	 * @return
	 */
	public static String strWordWrapRight(String str, int tab, char tabChar, char sepChar) {
		String ret = "";
		String line1 = strChatTrim(str);
		// first run the first left & right align
		if (line1.contains("" + sepChar)) {
			int lastPos = line1.length() - (ret.length() > 0 ? tab + 1 : 1);
			int sepPos = line1.indexOf(sepChar) + 1;
			while (lastPos > 0 && line1.charAt(lastPos) != ' ') {
				--lastPos;
			}
			if (lastPos == 0) {
				lastPos = line1.length() - (ret.length() > 0 ? tab + 1 : 1);
			} else if (sepPos > lastPos) {
				lastPos = sepPos;
			}
			ret += str.substring(0, sepPos);
			ret += padLeft(str.substring(sepPos, lastPos), ' ', chatwidth - getStringWidth(ret));
			str = str.substring(lastPos + 1);
		}
		while (str.length() > 0) {
			// find last char of first line
			if (getStringWidth(str) <= chatwidth) {
				return (ret.length() > 0 ? ret + "\n" + lastStrColor(ret) : "").concat(padLeft(str, tabChar));
			}
			line1 = strChatTrim(str);
			int lastPos = line1.length() - (ret.length() > 0 ? tab + 1 : 1);
			while (lastPos > 0 && line1.charAt(lastPos) != ' ') {
				--lastPos;
			}
			if (lastPos == 0) {
				lastPos = line1.length() - (ret.length() > 0 ? tab + 1 : 1);
			}
			//ret += strPadLeftChat(str.substring(0, lastPos), tabChar);
			ret += (ret.length() > 0 ? "\n" + lastStrColor(ret) : "") + padLeft(str.substring(0, lastPos), tabChar);
			str = str.substring(lastPos + 1);
		}
		return ret;
	}

	/**
	 * will left-align the start of the string until sepChar, then right-align the remaining paragraph
	 * @param str
	 * @param width
	 * @param tab
	 * @param tabChar
	 * @param sepChar
	 * @return
	 */
	public static String strWordWrapRight(String str, int width, int tab, char tabChar, char sepChar) {
		String ret = "";
		String line1 = strTrim(str, width);
		// first run the first left & right align
		if (line1.contains("" + sepChar)) {
			int lastPos = line1.length() - (ret.length() > 0 ? tab + 1 : 1);
			int sepPos = line1.indexOf(sepChar) + 1;
			while (lastPos > 0 && line1.charAt(lastPos) != ' ') {
				--lastPos;
			}
			if (lastPos == 0) {
				lastPos = line1.length() - (ret.length() > 0 && line1.length() > tab + 1 ? tab + 1 : 1);
			} else if (sepPos > lastPos) {
				lastPos = sepPos;
			}
			ret += str.substring(0, sepPos);
			ret += padLeft(str.substring(sepPos, lastPos), ' ', width - strLen(ret));
			str = str.substring(lastPos + 1);
		}
		while (str.length() > 0) {
			// find last char of first line
			if (strLen(str) <= width) {
				return (ret.length() > 0 ? ret + "\n" + lastStrColor(ret) : "").concat(Str.padLeft(str, width, tabChar));
			}
			line1 = strChatTrim(str);
			int lastPos = line1.length() - (ret.length() > 0 && line1.length() > tab + 1 ? tab + 1 : 1);
			while (lastPos > 0 && line1.charAt(lastPos) != ' ') {
				--lastPos;
			}
			if (lastPos == 0) {
				lastPos = line1.length() - (ret.length() > 0 && line1.length() > tab + 1 ? tab + 1 : 1);
			}
			//ret += strPadLeftChat(str.substring(0, lastPos), tabChar);
			ret += (ret.length() > 0 ? "\n" + lastStrColor(ret) : "") + Str.padLeft(str.substring(0, lastPos), width, tabChar);
			str = str.substring(lastPos + 1);
		}
		return ret;
	}

	public static String lastStrColor(String str) {
		int i = str.lastIndexOf('\u00A7');
		if (i >= 0 && i + 1 < str.length()) {
			return str.substring(i, i + 2);
		}
		return "\u00A7F";//white
	}

	private static boolean containsAlignTag(String str, String tag) {
		int pos = str.indexOf("<" + tag);
		if (pos >= 0) {
			return str.length() > pos + ("<" + tag).length()
					&& (str.charAt(pos + ("<" + tag).length()) == '>'
					|| str.charAt(pos + ("<" + tag).length() + 1) == '>');
		}
		return false;
	}

	private static boolean containsAlignTag(LinkedList<String> input, String tag) {
		for (String l : input) {
			if (containsAlignTag(l, tag)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * UNTESTED: DON'T USE YET
	 */
	public static String alignTags(String input, boolean minecraftChatFormat) {
		for (String fm : new String[]{"l", "r", "c"}) {
			while (containsAlignTag(input, fm)) {
				char repl = ' ';
				if (input.matches("^.*<" + fm + ".>.*$")) {
					repl = input.substring(input.indexOf("<" + fm) + 2).charAt(0);
					input = input.replaceFirst("<" + fm + ".>", "<" + fm + ">");
				}

				if (fm.equals("l")) {
					if (minecraftChatFormat) {
						input = padRight(input.substring(0, input.indexOf("<" + fm + ">")), input.indexOf("<" + fm + ">"), repl) + input.substring(input.indexOf("<" + fm + ">") + 3);
					} else {
						input = Str.padRight(input.substring(0, input.indexOf("<" + fm + ">")), input.indexOf("<" + fm + ">"), repl) + input.substring(input.indexOf("<" + fm + ">") + 3);
					}
				} else if (fm.equals("c")) {
					if (minecraftChatFormat) {
						input = padCenter(input.substring(0, input.indexOf("<" + fm + ">")), input.indexOf("<" + fm + ">"), repl) + input.substring(input.indexOf("<" + fm + ">") + 3);
					} else {
						input = Str.padCenter(input.substring(0, input.indexOf("<" + fm + ">")), input.indexOf("<" + fm + ">"), repl) + input.substring(input.indexOf("<" + fm + ">") + 3);
					}
				} else {
					if (minecraftChatFormat) {
						input = padLeft(input.substring(0, input.indexOf("<" + fm + ">")), input.indexOf("<" + fm + ">"), repl) + input.substring(input.indexOf("<" + fm + ">") + 3);
					} else {
						input = Str.padLeft(input.substring(0, input.indexOf("<" + fm + ">")), input.indexOf("<" + fm + ">"), repl) + input.substring(input.indexOf("<" + fm + ">") + 3);
					}
				}
			}
		}
		return input;
	}

	public static LinkedList<String> alignTags(LinkedList<String> input, boolean minecraftChatFormat) {
		if (input == null || input.size() == 0) {
			return input;
		}
		char[] repl = new char[input.size()];
		for (String fm : new String[]{"l", "r", "c"}) {
			while (containsAlignTag(input, fm)) {
				for (int i = 0; i < input.size(); ++i) {
					if (input.get(i).matches("^.*<" + fm + ".>.*$")) {// || input.get(1).matches("^.*<r.>.*$")) {
						repl[i] = input.get(i).substring(input.get(i).indexOf("<" + fm) + 2).charAt(0); //, input.get(1).indexOf(">")
						input.set(i, input.get(i).replaceFirst("<" + fm + ".>", "<" + fm + ">"));
					} else {
						repl[i] = ' ';
					}
				}
				int maxPos = 0;
				for (int i = 0; i < input.size(); ++i) {
					if (input.get(i).indexOf("<" + fm + ">") > maxPos) {
						maxPos = input.get(i).indexOf("<" + fm + ">");
					}
				}

				LinkedList<String> newinput = new LinkedList<String>();
				for (int i = 0; i < input.size(); ++i) {
					String line = input.get(i);

					if (line.indexOf("<" + fm + ">") != -1) {
						if (fm.equals("l")) {
							if (minecraftChatFormat) {
								newinput.add(MinecraftChatStr.padRight(line.substring(0, line.indexOf("<" + fm + ">")), maxPos, repl[i]) + line.substring(line.indexOf("<" + fm + ">") + 3));
							} else {
								newinput.add(Str.padRight(line.substring(0, line.indexOf("<" + fm + ">")), maxPos, repl[i]) + line.substring(line.indexOf("<" + fm + ">") + 3));
							}
						} else if (fm.equals("c")) {
							if (minecraftChatFormat) {
								newinput.add(MinecraftChatStr.padCenter(line.substring(0, line.indexOf("<" + fm + ">")), maxPos, repl[i]) + line.substring(line.indexOf("<" + fm + ">") + 3));
							} else {
								newinput.add(Str.padCenter(line.substring(0, line.indexOf("<" + fm + ">")), maxPos, repl[i]) + line.substring(line.indexOf("<" + fm + ">") + 3));
							}
						} else {
							if (minecraftChatFormat) {
								newinput.add(MinecraftChatStr.padLeft(line.substring(0, line.indexOf("<" + fm + ">")), maxPos, repl[i]) + line.substring(line.indexOf("<" + fm + ">") + 3));
							} else {
								newinput.add(Str.padLeft(line.substring(0, line.indexOf("<" + fm + ">")), maxPos, repl[i]) + line.substring(line.indexOf("<" + fm + ">") + 3));
							}
						}
					} else {
						newinput.add(line);
					}
				}
				input = newinput;
			}
		}
		return input;
	}

	public static String getChatColorStr(String col, ChatColor def) {
		ChatColor c = getChatColor(col);
		return c != null ? c.toString() : (def != null ? def.toString() : null);
	}
	
	public static ChatColor getChatColor(String col){
		if (col == null || col.length() == 0) {
			return null;
		} else if (col.length() >= 2 && col.startsWith("\u00A7")) {
			String c = col.substring(0, 2).toUpperCase();
			int ic = "0123456789ABCDEF".indexOf(c);
			return ChatColor.getByCode(ic);
		}
		col = col.toLowerCase().trim();
		/*
		#       &0 is black
		#       &1 is dark blue
		#       &2 is dark green
		#       &3 is dark sky blue
		#       &4 is red
		#       &5 is magenta
		#       &6 is gold or amber
		#       &7 is light grey
		#       &8 is dark grey
		#       &9 is medium blue
		#       &2 is light green
		#       &b is cyan
		#       &c is orange-red
		#       &d is pink
		#       &e is yellow
		#       &f is white
		 */
		if (col.equalsIgnoreCase("black")) {
			return ChatColor.BLACK;//"\u00A70"; //String.format("\u00A7%x", 0x0);//
		} else if (col.equals("dark blue")) {
			return ChatColor.DARK_BLUE;//"\u00A71"; // String.format("\u00A7%x", 0x1);//
		} else if (col.equals("green") || col.equals("dark green")) {
			return ChatColor.DARK_GREEN;//"\u00A72"; // String.format("\u00A7%x", 0x2);//
		} else if (col.equals("sky blue") || col.equals("dark sky blue") || col.equals("teal")) {
			return ChatColor.DARK_AQUA;//"\u00A73"; // String.format("\u00A7%x", 0x3);//
		} else if (col.equals("dark red")) {
			return ChatColor.DARK_RED;//"\u00A74"; // String.format("\u00A7%x", 0x4);//
		} else if (col.equals("magenta") || col.equals("purple")) {
			return ChatColor.DARK_PURPLE;//"\u00A75"; // String.format("\u00A7%x", 0x5);//
		} else if (col.equals("gold") || col.equals("amber") || col.equals("dark yellow")) {
			return ChatColor.GOLD;//"\u00A76"; // String.format("\u00A7%x", 0x6);//
		} else if (col.equals("light gray") || col.equals("light grey")) {
			return ChatColor.GRAY;//"\u00A77"; // String.format("\u00A7%x", 0x7);//
		} else if (col.equals("dark gray") || col.equals("dark grey") || col.equals("gray") || col.equals("grey")) {
			return ChatColor.DARK_GRAY;//"\u00A78"; // String.format("\u00A7%x", 0x8);//
		} else if (col.equals("blue") || col.equals("medium blue")) {
			return ChatColor.BLUE;//"\u00A79"; // String.format("\u00A7%x", 0x9);//
		} else if (col.equals("light green") || col.equals("lime") || col.equals("lime green")) {
			return ChatColor.GREEN;//"\u00A7a"; // String.format("\u00A7%x", 0xA);//
		} else if (col.equals("aqua") || col.equals("cyan") || col.equals("light blue")) {
			return ChatColor.AQUA;//"\u00A7b"; // String.format("\u00A7%x", 0xB);//
		} else if (col.equals("red") || col.equals("orange") || col.equals("orange-red") || col.equals("red-orange")) {
			return ChatColor.RED;//"\u00A7c"; // String.format("\u00A7%x", 0xC);//
		} else if (col.equals("pink") || col.equals("light red") || col.equals("light purple")) {
			return ChatColor.LIGHT_PURPLE;//"\u00A7d"; // String.format("\u00A7%x", 0xD);//
		} else if (col.equals("yellow")) {
			return ChatColor.YELLOW;//"\u00A7e"; // String.format("\u00A7%x", 0xE);//
		} else if (col.equals("white")) {
			return ChatColor.WHITE;//"\u00A7f"; //String.format("\u00A7%x", 0xF);//
		} else {
			return null;
		}
	}
}
