import java.awt.Color;

/**
 * Creates a greyscale based on the amount of blue in a pixel
 *
 * @author Mihail Vaporakis
 * @version 2021-11-17
 */
public class WarholFilter extends Filter
{
    /**
     * Sets the display name of this filter
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
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
        OFImage newImage = image;

        for(int y = 0; y < height / 2; y++) {
            for(int x = 0; x < width / 2; x++) 
            {
                newImage.setPixel(x, y, image.getPixel(x * 2, y * 2));
            }
        }

        for(int y = 0; y < height / 2; y++) {
            for(int x = 0; x < width / 2; x++) 
            {
                Color pixel = image.getPixel(x, y);
                int redScale = pixel.getRed() + 45;
                if (redScale >= 255)
                {
                    redScale = 255;
                }
                newImage.setPixel(x + (width / 2), y, new Color(redScale, pixel.getGreen(), pixel.getBlue()));
            }
        }

        for(int y = 0; y < height / 2; y++) {
            for(int x = 0; x < width / 2; x++) 
            {
                Color pixel = image.getPixel(x, y);
                int greenScale = pixel.getGreen() + 45;
                if (greenScale >= 255)
                {
                    greenScale = 255;
                }

                newImage.setPixel(x, y + (height / 2), new Color(pixel.getRed(), greenScale, pixel.getBlue()));
            }
        }

        for(int y = 0; y < height / 2; y++) {
            for(int x = 0; x < width / 2; x++) 
            {
                Color pixel = image.getPixel(x, y);
                int blueScale = pixel.getBlue() + 45;
                if (blueScale >= 255)
                {
                    blueScale = 255;
                }

                newImage.setPixel(x + (width / 2), y + (height / 2), new Color(pixel.getRed(), pixel.getGreen(), blueScale));
            }
        }
    }
}