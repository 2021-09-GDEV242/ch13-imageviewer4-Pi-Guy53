import java.awt.Color;

/**
 * Creates a greyscale based on the amount of green in a pixel
 *
 * @author Mihail Vaporakis
 * @version 2021-11-17
 */
public class GreenChannelFilter extends Filter
{
    /**
     * Sets the display name of this filter
     * @param name The name of the filter.
     */
    public GreenChannelFilter(String name)
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
                int greenScale = pixel.getGreen();
                image.setPixel(x, y, new Color(greenScale, greenScale, greenScale));
            }
        }
    }
}