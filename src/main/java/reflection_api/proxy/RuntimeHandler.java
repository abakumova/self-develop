package reflection_api.proxy;

public interface RuntimeHandler<R, P> {
    R process(P parameter);
}