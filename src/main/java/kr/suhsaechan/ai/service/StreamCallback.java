package kr.suhsaechan.ai.service;

/**
 * 스트리밍 응답 콜백 인터페이스
 * AI 응답을 실시간으로 처리할 때 사용합니다.
 *
 * <p>사용 예제:</p>
 * <pre>
 * suhAiderEngine.generateStream(request, new StreamCallback() {
 *     &#64;Override
 *     public void onNext(String chunk) {
 *         System.out.print(chunk);  // 실시간 출력
 *     }
 *
 *     &#64;Override
 *     public void onComplete() {
 *         System.out.println("\n완료!");
 *     }
 *
 *     &#64;Override
 *     public void onError(Throwable error) {
 *         System.err.println("에러: " + error.getMessage());
 *     }
 * });
 * </pre>
 *
 * @see SuhAiderEngine#generateStream(kr.suhsaechan.ai.model.SuhAiderRequest, StreamCallback)
 */
public interface StreamCallback {

    /**
     * 응답 청크가 도착할 때마다 호출됩니다.
     * AI가 토큰을 생성할 때마다 실시간으로 호출됩니다.
     *
     * @param chunk 텍스트 조각 (토큰 단위)
     */
    void onNext(String chunk);

    /**
     * 스트림이 정상적으로 완료되었을 때 호출됩니다.
     * AI가 응답 생성을 완료하면 호출됩니다.
     */
    void onComplete();

    /**
     * 스트림 처리 중 에러가 발생했을 때 호출됩니다.
     *
     * @param error 발생한 예외 (주로 SuhAiderException)
     */
    void onError(Throwable error);
}
