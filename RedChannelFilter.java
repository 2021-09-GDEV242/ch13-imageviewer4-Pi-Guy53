import java.awt.Color;

/**
 * Creates a greyscale based on the amount of red in a pixel
 *
 * @author Mihail Vaporakis
 * @version 2021-11-17
 */
public class RedChannelFilter extends Filter
{
    /**
     * Sets the display name of this filter
     * @param name The name of the filter.
     */
    public RedChannelFilter(String name)
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
                int redScale = pixel.getRed();
                image.setPixel(x, y, new Color(redScale, redScale, redScale));
            }
        }
    }
}