import java.awt.Color;

/**
 * Appies a blue tint to the picture
 *
 * @author Mihail Vaporakis
 * @version 2021-11-27
 */
public class BlueTintFilter extends Filter
{
    /**
     * Sets the display name of this filter
     * @param name The name of the filter.
     */
    public BlueTintFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) 
            {
                Color pixel = image.getPixel(x, y);
                int blueScale = pixel.getBlue() + 25;
                if (blueScale >= 255)
                {
                    blueScale = 255;
                }

                image.setPixel(x, y, new Color(pixel.getRed(), pixel.getGreen(), blueScale));
            }
        }
    }
}
