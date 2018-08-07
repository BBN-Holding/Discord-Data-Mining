package discord.data.mining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

/**
 * @author Hax
 * @time 12:52 30.06.2018
 * @project Discord-Data-Mining
 * @package discord.data.mining
 * @class Stats
 **/

public class Stats {

    public static void start() {

        Thread diagramm = new Thread(() -> {
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Date date = new Date();
                    Calendar calendar = GregorianCalendar.getInstance();
                    calendar.setTime(date);
                    if (calendar.get(Calendar.MINUTE)==0) {
                        try {
                            FileReader fr = new FileReader("stats.txt");
                            BufferedReader br = new BufferedReader(fr);

                            String zeile = "";
                            StringBuilder stringBuilder = new StringBuilder();
                            while ((zeile = br.readLine()) != null) {
                                stringBuilder.append(zeile);
                            }
                            br.close();

                            String[] stats = stringBuilder.toString().split(" ");
                            String statsstring = stringBuilder.toString();
                            statsstring = statsstring.replaceFirst(stats[0]+" ", "");
                            statsstring = statsstring+" "+Main.Actionperh;
                            FileWriter fw = new FileWriter("stats.txt");
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(statsstring);
                            bw.close();
                            Main.Actionperh =0;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (calendar.get(Calendar.HOUR_OF_DAY)==0&&calendar.get(Calendar.MINUTE)==0) {
                        try {
                            FileReader fr = new FileReader("stats.txt");
                            BufferedReader br = new BufferedReader(fr);

                            String zeile = "";
                            StringBuilder stringBuilder = new StringBuilder();
                            while ((zeile = br.readLine()) != null) {
                                stringBuilder.append(zeile);
                            }
                            br.close();
                            String[] datas = stringBuilder.toString().split(" ");
                            ArrayList<Integer> data = new ArrayList<>();
                            for (String dataa:datas) {
                                data.add(Integer.parseInt(dataa));
                            }
                            int max = -Integer.MAX_VALUE;
                            for (Integer aData : data) {
                                if (aData > max)
                                    max = aData;
                            }
                            BufferedImage bufferedImage = ImageIO.read(new File("Diagramm.jpg"));
                            Graphics2D g2 = bufferedImage.createGraphics();
                            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                            int w = bufferedImage.getWidth();
                            int h = bufferedImage.getHeight();
                            g2.draw(new Line2D.Double(24, 24, 24, h - 24));
                            g2.draw(new Line2D.Double(24, h - 24, w - 24, h - 24));
                            Font font = g2.getFont();
                            FontRenderContext frc = g2.getFontRenderContext();
                            LineMetrics lm = font.getLineMetrics("0", frc);
                            float sh = lm.getAscent() + lm.getDescent();
                            String s = "data";
                            float sy = 24 + ((h - 2 * 24) - s.length() * sh) / 2 + lm.getAscent();
                            for (int i = 0; i < s.length(); i++) {
                                String letter = String.valueOf(s.charAt(i));
                                float sw = (float) font.getStringBounds(letter, frc).getWidth();
                                float sx = (24 - sw) / 2;
                                g2.drawString(letter, sx, sy);
                                sy += sh;
                            }
                            s = "x axis";
                            sy = h - 24 + (24 - sh) / 2 + lm.getAscent();
                            float sw = (float) font.getStringBounds(s, frc).getWidth();
                            float sx = (w - sw) / 2;
                            g2.drawString(s, sx, sy);
                            // Draw lines.
                            double xInc = (double) (w - 2 * 24) / (data.size() - 1);
                            double scale = (double) (h - 2 * 24) / max;
                            g2.setPaint(Color.green.darker());
                            for (int i = 0; i < data.size() - 1; i++) {
                                double x1 = 24 + i * xInc;
                                double y1 = h - 24 - scale * data.get(i);
                                double x2 = 24 + (i + 1) * xInc;
                                double y2 = h - 24 - scale * data.get(i + 1);
                                g2.draw(new Line2D.Double(x1, y1, x2, y2));
                            }
                            // Mark data points.
                            g2.setPaint(Color.red);
                            for (int i = 0; i < data.size(); i++) {
                                double x = 24 + i * xInc;
                                double y = h - 24 - scale * data.get(i);
                                g2.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
                            }
                            ByteArrayOutputStream os = new ByteArrayOutputStream();
                            ImageIO.write(bufferedImage, "jpg", os);
                            Main.manager.get(0).getTextChannelById("462534066869370882").sendFile(new ByteArrayInputStream(os.toByteArray()), "test.jpg").queue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            new Timer().schedule(timerTask, 30000, 60000);
        });
        diagramm.start();

    }

}
