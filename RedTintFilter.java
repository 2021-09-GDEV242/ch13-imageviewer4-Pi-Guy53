import java.awt.Color;

/**
 * Appies a red tint to the picture
 *
 * @author Mihail Vaporakis
 * @version 2021-11-27
 */
public class RedTintFilter extends Filter
{
    /**
     * Sets the display name of this filter
     * @param name The name of the filter.
     */
    public RedTintFilter(String name)
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
                int redScale = pixel.getRed() + 25;
                if (redScale >= 255)
                {
                    redScale = 255;
                }

                image.setPixel(x, y, new Color(redScale, pixel.getGreen(), pixel.getBlue()));
            }
        }
    }
}